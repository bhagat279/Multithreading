package Thread;

class Display {
    public synchronized void show(String name) {
        for (int i = 1; i <= 5; i++) {

            System.out.println(name);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }

        }

    }
}

class MySynch extends Thread {
    Display d;
    String name;

    public MySynch(Display d, String name) {
        this.d = d;
        this.name = name;

    }

    public void run() {

        d.show(name);
    }
}

public class Synchronize_1 {
    public static void main(String[] args) {

        Display d = new Display();
        Display d1 = new Display();
        MySynch ms = new MySynch(d, "ravi");
        MySynch ms1 = new MySynch(d, "anish");
       // ms.start();
        ms1.start();

        MySynch ms2 = new MySynch(d1,"dhoni");
        ms2.start();


    }
}

/*
===>Synchronized: It is a modifier applicable only for methods and block but not for claases and variables

===> If multiple threads are trying to operate simultaneously on the same java object, then there may be chance of
    data-inconsistency problem, To overcome this problem we should go for Synchronized keyword.

    If a method()/Block declared as a Synchronized, then at a time only one thread allow to execute that method()/ Block
    so data inconsistency problem will be resolved


===> Internally Synchronization is implemeted by using lock, every Object in java has a uniq Lock.
     Whenever we are using Synchronized keyword, then only Lock() concept will come into the picture.

===> If a thread wants to execute Synchronized method on the given Object, first it has to get Lock of that object
    once thread got the lock, then it is allow to execute  any Synchronized method on that object.
    Once method exceution completes automatically thread releases lock.

    Acquiring and release lock internally takes care by JVM and programmer not responsible for this activity.


===>Where to user Synchronized:
   Synchronized area{
    wherever we are doing update operation object
    (add,delete,replace)
   }
   non-Synchronized area{
   wherever we are doing read operation on object
   (read,get)
   }

   Example:

   Synchronized area{
         check tickt avaibility
   }
   non-Synchronized area{
         booktickt
   }


===> Even though wich method is synchronized, we will get irregular output, because threads are operating on different
     java objects.
     If multiple threads are operating on same java object, then synchronization is required.
     If multiple threads are operating on multiple java objects then synchronization is not required.

        Display d = new Display();
        Display d1 = new Display();

        MySynch ms = new MySynch(d, "ravi");
        MySynch ms2 = new MySynch(d1,"dhoni");

        ms1.start();
        ms2.start();
 */
