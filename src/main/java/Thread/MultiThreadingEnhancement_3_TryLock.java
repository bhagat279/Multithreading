package Thread;

import java.util.concurrent.locks.ReentrantLock;

class MyThreadTryLock extends Thread
{
   static ReentrantLock l = new ReentrantLock();

   MyThreadTryLock(String name)
   {
       super(name);
   }

   public void run()
   {
       if(l.tryLock())
       {
           System.out.println(Thread.currentThread().getName()+" get lock and perform safe operation");
           try{
               Thread.sleep(2000);
           }catch (Exception e)
           {

           }
           l.unlock();
       }
       else
       {
           System.out.println(Thread.currentThread().getName()+" unable to get lock and hence perform alternative operation");
       }
   }

}

public class MultiThreadingEnhancement_3_TryLock {
    public static void main(String[] args) {
        MyThreadTryLock myThreadTryLock1 = new MyThreadTryLock("first thread");
        MyThreadTryLock myThreadTryLock2 = new MyThreadTryLock("sec thread");

        myThreadTryLock1.start();
        myThreadTryLock2.start();

    }
}
