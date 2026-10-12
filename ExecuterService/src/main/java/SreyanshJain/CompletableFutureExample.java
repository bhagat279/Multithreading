package SreyanshJain;

import java.util.concurrent.*;

public class CompletableFutureExample {
    private static CompletableFuture<String> completableFuture;

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

     //CompletableFuture.supplyAsync()
        /*CompletableFuture<String > completableFuture=  CompletableFuture.supplyAsync(()->{return "completablefuture example";}
                ,executor);

        try{
            System.out.println(completableFuture.get());
        }catch (Exception e)
        {

        }*/

      //CompletableFuture.thenApply()
       /* CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println("supplyAsync() method running in :" + Thread.currentThread().getName());
                    return "supplyAsync() method example";
                }, executor)
                .thenApply((String val) -> {
                    System.out.println("thenApply() method running in :" + Thread.currentThread().getName());
                    return val + " thenApply() method example";
                });
        try{
            System.out.println(completableFuture.get());
        }catch (Exception e)
        {

        }*/

        //CompletableFuture.thenApplyAsync()
      /*  CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync() method running in :" + Thread.currentThread().getName());
            return "supplyAsync() method example";
        }, executor).thenApplyAsync((String val) -> {
            System.out.println("thenApplyAsync() method running in :" + Thread.currentThread().getName());
            return val+": thenApplyAsync() method example";
        },executor);

        try{
            String string = completableFuture1.get();
            System.out.println(string);
        }catch (Exception e)
        {

        }*/

        //thenCopmose()======Its mentain order=========================================================================
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync-1 running in :" + Thread.currentThread().getName());
            return "this ";
        }, executor).thenCompose((String val) -> {
            System.out.println("thenCompose-2 running in :" + Thread.currentThread().getName());
            CompletableFuture<String> completableFuture2 =  CompletableFuture.supplyAsync(() -> val + ": is");
            return completableFuture2;
        });

        try
        {
            System.out.println( completableFuture1.get());
        }catch (Exception e)
        {

        }

        //thenCopmoseAsync()=========================================================================================
       /* CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync-1 running in :" + Thread.currentThread().getName());
            return "this ";
        }, executor).thenComposeAsync((String val) -> {
            System.out.println("thenComposeAsync-2 running in :" + Thread.currentThread().getName());
            CompletableFuture<String> completableFuture2 =  CompletableFuture.supplyAsync(() -> val + ": is thenComposeAsync");
            return completableFuture2;
        },executor);

        try
        {
            System.out.println( completableFuture1.get());
        }catch (Exception e)
        {

        }*/

        //thenAccept()
       /* CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println("supplyAsync is running in :" + Thread.currentThread().getName());
                    return "My name is";
                }, executor)
                .thenAccept((String val) -> System.out.println(val + " Ravi"));

        try{
            System.out.println(voidCompletableFuture.get());
        }catch (Exception e)
        {

        }*/

        //thenAcceptAsync
       /* CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    System.out.println("supplyAsync is running in :" + Thread.currentThread().getName());
                    return "My name is";
                }, executor)
                .thenAcceptAsync((String val) ->{
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(val + " Ravi");

                },executor);*/


        //thenCombine-->use to combine 2 Comaparable future
       /* CompletableFuture<Integer> integerCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            return 10;
        }, executor);

        CompletableFuture<Integer> integerCompletableFuture2 = CompletableFuture.supplyAsync(() -> {
            return 5;
        }, executor);

        CompletableFuture<Integer> integerCompletableFuture = integerCompletableFuture1
                .thenCombine(integerCompletableFuture2, (v1, v2) -> v1 + v2);

        try{
            System.out.println(integerCompletableFuture.get());
        }catch (Exception e)
        {}*/

        //thenCombineAsync
       /* CompletableFuture<Integer> integerCompletableFuture1 = CompletableFuture.supplyAsync(() -> {
            return 10;
        }, executor);

        CompletableFuture<Integer> integerCompletableFuture2 = CompletableFuture.supplyAsync(() -> {
            return 5;
        }, executor);

        CompletableFuture<Integer> integerCompletableFuture = integerCompletableFuture1
                .thenCombineAsync(integerCompletableFuture2, (v1, v2) ->
                {
                    System.out.println(Thread.currentThread().getName());
                    return v1 + v2;
                }, executor);

        try{
            System.out.println(integerCompletableFuture.get());
        }catch (Exception e)
        {}*/

    }
}
