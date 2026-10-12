package Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class PrintJob implements  Runnable
{
    String name;
    PrintJob(String name)
    {
        this.name = name;
    }

    public void run()
    {
        System.out.println(name+"..job started by Thread: "+ Thread.currentThread().getName());
        try{
            Thread.sleep(2000);
       }catch(Exception e)
        {

        }
        System.out.println(name+"..job completed by Thread "+ Thread.currentThread().getName());
    }
}

public class ThreadPool_ExecuterFramwork {
    public static void main(String[] args) {

        PrintJob[] printJobs = {
                new PrintJob("ravi"),
                new PrintJob("sk"),
                new PrintJob("anish"),
                new PrintJob("mota")
        };

        ExecutorService service = Executors.newFixedThreadPool(3);

        for(PrintJob job : printJobs)
        {
            service.submit(job);
        }
        service.shutdown();


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


===> While developing web servers and application servers, we can use thread pool concept.
    Default Thread Pool size for most of the servers is 60.



 */