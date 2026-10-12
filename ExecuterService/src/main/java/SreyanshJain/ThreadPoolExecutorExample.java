package SreyanshJain;

//import practice.CustomRejectedException;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,
                4,
                10,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2),
                // Executors.defaultThreadFactory(),
                new CustomThreadFactory(),
                //new ThreadPoolExecutor.AbortPolicy()
                new CustomRejectedExecutionHandler()
        );

        executor.allowCoreThreadTimeOut(true);

        for(int i =1;i<=7;i++)
        {
         int f=i;
           executor.submit(()->{
               try {
                   Thread.sleep(1000); // task ko slow bana do
               } catch (InterruptedException e) {}
               System.out.println("task " + f + " done by " + Thread.currentThread().getName());

           });
        }

        executor.shutdown();
    }
}

class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
       // thread.setName("ravi");
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.setDaemon(false);

        return thread;
    }
}

class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("task rejected " + r.toString());
    }
}
