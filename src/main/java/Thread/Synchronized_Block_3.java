package Thread;

class Employee {
    public void show(String name) {

     //  synchronized (Employee.class)
        synchronized (this) {
            for (int i = 1; i <= 3; i++) {
                System.out.println(name);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        }
    }
}

class MyBlock extends Thread {
    Employee e;
    String name;

    MyBlock(Employee e, String name) {
        this.e = e;
        this.name = name;
    }

    public void run() {
        e.show(name);
    }
}

public class Synchronized_Block_3 {
    public static void main(String[] args) {

       /* Employee e1 = new Employee();

        MyBlock myBlock = new MyBlock(e1, "ravi");
        MyBlock myBlock1 = new MyBlock(e1, "bhagat");

        myBlock.start();
        myBlock1.start();*/

        // this will give irregular output, although we used  synchronized (this), because diff threads calling diff obj
       /* Employee e1 = new Employee();
        Employee e2 = new Employee();

        MyBlock myBlock = new MyBlock(e1, "ravi");
        MyBlock myBlock1 = new MyBlock(e2, "bhagat");

        myBlock.start();
        myBlock1.start();*/

    }

}
/*

===> The main advantage of Synchronize Block over Synchronize method is it reduces waiting time of thread and
     increase performance of system.

===> We can declared Synchronize Block as follows:

    1. To get Lock of current Object
       Synchronized(this)
       {
         If thread got lock of current object then only it is allow to execute this area.
       }

    2. To get Lock of particular Object "b"

       Synchronized(b)
       {
         If thread got lock of particular object "b" then only it is allow to execute this area.
       }

    3. To get class-level lock

       Synchronized(Display.class)
       {
         If thread got class-level lock of Display class, then only it is allow to execute this area.
       }

Q.  Where we can use Synchronized kyeword.
Q1. What is Advantage of  Synchronized keyword.
Q2. What is did-Advantage of  Synchronized keyword.
Q3. what is Race-Condition
===> If multiple threads are operating simultaneously on same Java object then there may be chance of Data-Inconsistency.
     this is called Race-Condition, we can overcome this problem by using Synchronized keyword.
Q4. What is Object lock, and when it is required.
===> Every java object has Uniq lock, that is Object lock, whenever thread wants to execute "instance Synchronized method".
Q4. What is class-level lock, and when it is required.
===> Every class in java has uniq lock, that is class-level-lock, when thread required to execute "static Synchronized
     method"
 */
