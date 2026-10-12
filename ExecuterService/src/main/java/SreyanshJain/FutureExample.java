package SreyanshJain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) {
    ThreadPoolExecutor executors=   new ThreadPoolExecutor(
               2,
               4,
               1,
               TimeUnit.SECONDS,
               new ArrayBlockingQueue<>(4),
               Executors.defaultThreadFactory(),
               new ThreadPoolExecutor.AbortPolicy()
       );

    executors.allowCoreThreadTimeOut(true);


      //================> executors.submit(Runnable r);======================================================>
       /* Future<?> futureObj = executors.submit(() -> {
            try {
                Thread.sleep(4000);
                System.out.println("This is the runnable Task");
            } catch (Exception e) {

            }
        });

        System.out.println("is Done: "+ futureObj.isDone());

        try {
          futureObj.get(2, TimeUnit.SECONDS);
        }catch (TimeoutException T)
        {
            System.out.println("Timeout");
        }
        catch (Exception e)
        {
            System.out.println("other");
        }

        try {
          Object obj  futureObj.get();
          System.out.println(obj==null);
        }catch (Exception e)
        {

        }

        System.out.println("is done: "+ futureObj.isDone());
        System.out.println("is cancelled: "+futureObj.isCancelled());*/

        //================> executors.submit(Runnable R, T Result);=====================================================>

        /*List<Integer> list = new ArrayList<>();
        Future<List<Integer>> futureObj = executors.submit(new MyRunnable(list), list);
        try {

            System.out.println(futureObj.get());
            System.out.println(list.get(0));
            List<Integer> list1 = futureObj.get();
            System.out.println(list1.get(0));
        }catch (Exception e)
        {

        }*/

    //=================executors.submit(Runnable R, T Result);=====================================================>
      /*  List<Integer> list2 = new ArrayList<>();
        Future<List<Integer>> futureObj = executors.submit(() -> {
            list2.add(40);
                    list2.add(50);
        }, list2);

        try {
            List<Integer> list = futureObj.get();
            System.out.println(list);
        }catch (Exception e)
        {

        }*/
//==============================executors.submit(Callable c);===========================================================
    Future<String > futureObj= executors.submit(()->{
            return "This is callable";
        });

    try {
        System.out.println(futureObj.get());
    }catch (Exception e)
    {

    }




    }
}

/*
boolean cancel()
boolean is Cancelled()
boolean isDone()
V get()
V get(long timeout, TimeUnit unit)
 */