package Thread;

import java.util.concurrent.*;

class MyCallable implements Callable
{
    int n;
    MyCallable(int n)
    {this.n=n;}

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" will find sum of first : "+n+" :numbers");
        int sum=0;
        for(int i=1;i<=n;i++)
        {
            sum+= i;
        }
        return sum;
    }
}

public class Callables {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyCallable[] myCallables ={
                new MyCallable(5),
                new MyCallable(10),
                new MyCallable(15),
                new MyCallable(5),
                new MyCallable(10),
                new MyCallable(15),
        };

        ExecutorService service = Executors.newFixedThreadPool(3);
        
        for(MyCallable job:myCallables)
        {
            Future f = service.submit(job);
            System.out.println(f.get());
        }
        service.shutdown();
    }
}
/*
===>Callable: In the case of runnable Thread not returns anything after completing the job.
              If the Thread is required to retuns some result after execution, then we should go for Callable.
              It contains only 1 below method.

              public Object call(); throws execption

              If we submit callable object to executor then after completeing the job Thread returns an object of type "Future"


              Future f = service.submit(job);




 */