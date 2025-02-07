package Thread;

class MyYield extends Thread
{
    public void run()
    {
        for(int i=1;i<=3;i++)
        {
            System.out.println("child-yield");
            Thread.yield();
        }
    }
}

public class Yieldd {
    public static void main(String[] args) {

        MyYield my = new MyYield();
        my.start();

        for(int i=1;i<=3;i++)
        {
            System.out.println("main");
            Thread.yield();
        }

    }
}
/*
===> We can prevent thread execution using below methods
    1. yield()
    2. join()
    3. sleep()


===>yield(): It pause current executing thread to give the chance for other waiting threads of same priority.
             If there is no waiting threads or all waiting threads have low priority, then same thread can continue
             its execution.


===> If multiple threads are waiting with same priority, then which waiting thread will get chance we can not expect
     it depends on T.S.

===> The thread on which we use yield() method, it will go to waiting state and when it will get chance once again
     its depend on T.S.

===> Some plateform/operating system does not provide support to yield() method, so output may be vary

 */