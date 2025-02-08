package Thread;
class A{
    public synchronized void d1(B b1)
    {
        try
        {
            Thread.sleep(2000);
        }catch (Exception e){

        }
        System.out.println(" A class calling B class last method");
        b1.last();
    }

    public synchronized void last()
    {
        System.out.println("A-Last method");
    }
}
class B{
    public synchronized void d2(A a1)
    {
        System.out.println(" B class calling A class last method");
        a1.last();
    }
    public synchronized void last()
    {
        System.out.println("B-Last method");
    }
}
public class Deadlocks extends Thread{

    A a = new A();
    B b = new B();

    public void m1()
    {
        a.d1(b);// this line executed by main thread
    }
    public void run()
    {
        b.d2(a); //// this line executed by child thread
    }
    public static void main(String[] args) {
      Deadlocks deadlocks= new Deadlocks();
      deadlocks.start();
      deadlocks.m1();
    }
}
/*
===> If 2 threads are waiting for each other forever such type of infinite waiting is called deadlock.

===> Synchronized keyword is only reason for Deadlock, Hence while using Synchronized keyword we have to take special
     care, there are no resolution techniqe for Deadlock but several preventation technique are available.


===>Starwation: When thread waits for long time but at certain time waiting ends, is called Deadlock.
                Suppose we have 1 crore threads, any only 1 thread has priority 1, and remaing all threads has priority
                10, then after excuting all thread of priority 10, that thread will execute.
 */