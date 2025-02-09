package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool_ExecuterFramwork {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(5);


    }
}
/*

Thread-Pool: Creating a Thread for every job, may create problems on memory performance, to overcome this we should
             go for Thread-Pool.

             Thread Pool is a Pool of already created Threads ready to do our job.

             Java 1.5 version introduces Thread_Pool framework to implements Thread-Pool.
             Thread-Pool framework also known as Executor Framework.

             We can create a Thread-Pool as below:
             ExecutorService service = Executors.newFixedThreadPool(5);

             We can submit a runnable job by using submit() mehods:
             service.submit(job);

             We can shutdown ExecutorService by using shutdown() methods:
             service.shutdown();





 */