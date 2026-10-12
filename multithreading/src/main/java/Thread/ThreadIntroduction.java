package Thread;

//=====================================Creating thread using Thread class=============================================

class MyThread extends Thread
{
    public void run()
    {
        for(int i=1;i<=5;i++)
        {
            try {
                Thread.sleep(1000);
                System.out.println("child thread :"+Thread.currentThread().getName());
            }catch (Exception e)
            {

            }
        }
    }
}

//=====================================Creating thread using Runnable interface=========================================
class MyThread1 implements Runnable
{
    public void run()
    {
        for(int i=1;i<=5;i++)
        {
            try {
                Thread.sleep(1000);
                System.out.println("child thread using runnable:"+Thread.currentThread().getName());
            }catch (Exception e)
            {

            }
        }
    }
}


public class ThreadIntroduction {
    public static void main(String[] args) {

        MyThread mt = new MyThread();
        mt.start();
        //mt.start(); // It will give .IllegalThreadStateException, because using first mt.start(), it went into dead state

        MyThread1 mt1 = new MyThread1();
        Thread t = new Thread(mt1);
        t.start();

    }
}
/*
===>MultiTasking: Doing multiple task parralally.
    1.MultiProcessing
    2.MultiThreading


    1.MultiProcessing: Executing multiple task paralally and each task does not depend on each other.
                      In computer: You-tube,Chrome,VLC, NotePad, Intelijj Idea.

    2.MultiThreading: Executing multiple thread paralally and each thread depend depends on each other.
                       It is a subpart of Process.


===> We can create Thread using 2 way:
     1. Using Thread class
     2. Using Runnable interface(It has run() method)


===> LifeCycle of Thread:

    MyThread mt =new MyThread();=======>Born-------Start===========>Runnable------if t.s provide processer
    =========>running -------if run() complete=========>Dead state

===> Thread Schedular: A Thread Scheduler in Java is a part of the Java Virtual Machine (JVM) responsible for determining
                      the order in which threads are execute.
 */