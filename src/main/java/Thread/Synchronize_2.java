package Thread;
class Display2{
    public static synchronized void show(String name)
    {
        for(int i=1;i<=5;i++)
        {
            System.out.println(name);
            try
            {
                Thread.sleep(2000);
            }
            catch (Exception e)
            {
            }

        }

    }
}
class MySynch2 extends  Thread
{
    Display2 d;
    String name;

    public MySynch2(Display2 d,String name)
    {
        this.d=d;
        this.name=name;

    }

    public void run()
    {

            d.show(name);

    }
}

public class Synchronize_2 {
    public static void main(String[] args) {

        Display2 d = new Display2();
        Display2 d1 = new Display2();

        MySynch2 ms1 = new MySynch2(d, "ravi");
        MySynch2 ms2 = new MySynch2(d1,"dhoni");

        ms1.start();
        ms2.start();

    }
}

/*
 If multiple threads are operating on same java object, then synchronization is required.
 If multiple threads are operating on multiple java objects then synchronization is not required.


===> class-level lock: Every class in java has a uniq lock, which is class-level lock

===> If a thread wants to execute static synchronized method then thread require class-level lock.
    Once thread got class-level lock then, it is allowed to execute any static synchronized method of that class.
    Once method execution complete automatically thread release the lock.

    synchronization show() ==> this will take Object-level lock
    static synchronization show() ==> this will take class-level lock

===>while a thread executing static synchronized method() the remaining threads are not allow to execute
    any static synchronized method() of that class simultaneously,
    but remaining threads are allow to execute the following methods simultaneously:

    static show()
    synchronized show()
    show()


 */
