package Thread;

import java.util.StringTokenizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Displays {

    ReentrantLock l = new ReentrantLock();

    public void wish(String name) {
        l.lock();
        for (int i = 1; i <= 3; i++) {

            System.out.print("Good morning :");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {

            }
            System.out.println(name);
        }
        l.unlock();
    }
}

class MyThreadLock extends Thread {
    Displays d;
    String name;

    MyThreadLock(Displays d, String name) {
        this.d = d;
        this.name = name;
    }

    public void run() {
        d.wish(name);
    }
}

public class MultiThreadingEnhancement_3 {
    public static void main(String[] args) {

        /*ReentrantLock l = new ReentrantLock(true);
        l.lock();
        l.lock();

        System.out.println(l.isLocked());
        System.out.println(l.isHeldByCurrentThread());
        System.out.println(l.getQueueLength());
        l.unlock();
        System.out.println(l.getHoldCount());
        System.out.println(l.isLocked());
        l.unlock();
        System.out.println(l.getHoldCount());
        System.out.println(l.isLocked());
        System.out.println(l.isFair());*/


//======================================================================================================================

        Displays d = new Displays();
        MyThreadLock myThreadLock1 = new MyThreadLock(d, "ravi");
        MyThreadLock myThreadLock2 = new MyThreadLock(d, "bhagat");

        myThreadLock1.start();
        myThreadLock2.start();

    }
}
/*

===>ReentrantLock:
    It is the implementation class of Lock interface and it is the direct child class of object.

    ReentrantLock means a thread can acquired same lock multiple times without any issue.
    Internally ReentrantLock increments thread persional counts whenever we call lock method and decrement count
    value whenever thread calls unlock method and lock will be realised whenever count reaches "0"

    ReentrantLock l = new ReentrantLock();
    l.lock();// holds count=1
    l.lock();// holds count=2
    l.lock();// holds count=3

    l.unlock();// holds count=2
    l.unlock();// holds count=1
    l.unlock();// holds count=0


===> Constructors

    1. ReentrantLock l = new ReentrantLock();
       Creates an instance of ReentrantLock

    2. ReentrantLock l = new ReentrantLock(boolean fairness);
       creates ReentrantLock with given fairness policy.
       If the fairness "true" then longest waiting thread can acquired the lock if it is available.
       that is it follow first come first serve policy.
       If fairness is "false" then which waiting thread will get chance we cant expect.

       The default value for fairness is :"false"

===>  Important methods of ReentrantLock.

      1. void lock();
      2. boolean tryLock();
      3. boolean tryLock(long l, TimeUnit t);
      4. void lockInterruptibly();
      5. void unlock();


     1. int getHoldCount(); // returns number of holds on this lock by current thread.
     2. boolean isHeldByCurrentThread(); // true/false
     3. int getQueueLength();// returns total count of threads waiting for the lock.
     4. Collection getQueuedThreads()// returns all thread waiting for lock.
     5. boolean hasQueuedThreads()// returns true if any thread waiting to get the lock
     6. boolean isLocked() // true/false
     7. boolean isfair();// returns true if the fairness policy is set with "true" value
     8. Thread getOwner();//




 */