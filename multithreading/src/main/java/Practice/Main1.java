package Practice;

import InterThread.Producer;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

class MyThread implements Callable
{
    int n=0;

   public MyThread(int n)
    {
        this.n=n;
    }
    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" giving sum of first "+n+" numbers");
        int sum=0;
        for(int i=1;i<=n;i++)
        {
            sum+=i;
        }
        return sum;
    }
}
public class Main1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        MyThread[] myThreads = {
                new MyThread(4),
                new MyThread(8),
                new MyThread(6)
        };

        MyThread m = new MyThread(3);
        ExecutorService service = Executors.newFixedThreadPool(3);

        Future submit = service.submit(m);
        System.out.println(submit.get());


        service.shutdown();
    }
}
