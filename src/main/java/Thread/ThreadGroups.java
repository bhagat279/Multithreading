package Thread;

class MyThreads extends Thread
{
  MyThreads(ThreadGroup g, String name)
  {
      super(g,name);
  }

  public void run()
  {
      System.out.println("child thread");
      try{
         Thread.sleep(5000);
      }catch (Exception e)
      {

      }
  }
}

public class ThreadGroups {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println(Thread.currentThread().getThreadGroup().getName()); // main group
  //      System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());// system group

     //constructors
       /* ThreadGroup g = new ThreadGroup("firstGroup"); //
          System.out.println(g.getName());//firstGroup
          System.out.println(g.getParent().getName());//main
          System.out.println(g.activeCount());// 0, because still no-threads assign in this group


        Thread t1 = new Thread(g,"firstthread");
        t1.start();
        System.out.println(g.activeCount());// 1, because 1 thread assign in this group and also started that thread.*/





       // ThreadGroup g2 = new ThreadGroup(g,"secondgroup");
       // System.out.println(g2.getParent().getName()); //firstGroup


    //=======================================setting maxpriority to ThreadGroups========================================

        /*ThreadGroup tg = new ThreadGroup("fisrtGroup");

        Thread t1 = new Thread(tg,"firstThread");
        Thread t2 = new Thread(tg,"secThread");
        System.out.println("first thread priority:"+t1.getPriority()+":"+" sec thread priority:"+t2.getPriority());

        tg.setMaxPriority(3);

        Thread t3 = new Thread(tg,"3rd thread");

        System.out.println("t3 priority is:"+ t3.getPriority());*/

//====================================================================================================================

   /* ThreadGroup pg = new ThreadGroup("paranetgroup");
    ThreadGroup cg = new ThreadGroup(pg,"childgroup");

    MyThreads t1 = new MyThreads(pg,"childthread-1");
    MyThreads t2 = new MyThreads(pg,"childthread-2");
    t1.start();
    t2.start();
    System.out.println("total thread: "+pg.activeCount());
    System.out.println("total group : "+pg.activeGroupCount());
    pg.list();

    Thread.sleep(6000);
    System.out.println("total thread: "+pg.activeCount());
    System.out.println("total sub-group : "+pg.activeGroupCount());
    pg.list();*/


//============= write a program to display all active thread name belongs to system group and its child group.==========

       /* ThreadGroup system = Thread.currentThread().getThreadGroup().getParent();

        Thread[] t = new Thread[system.activeCount()];

        system.enumerate(t);

        for(Thread t1:t)
        {
            System.out.println(t1.getName()+":"+t1.isDaemon());
        }*/


    }
}
/* =======================================================Comments======================================================
===>Based on functionality we can group threads into a single unit, which is nothing but Thread Group. That is thread
    group contains a gorup of threads.
    In addition to threads, thread group can also contain sub-thread groups.


===>The main advantage of maintaining threads in the form of thread group is we can perform common operation very easily

===> Every Thread in java belongs to some group, main thread belongs to "main" group.
     Every thread group in java is the child group of "system" group, hence system group acess root for all thread groups
     in java.

===> System group contains several system level threads, like
     finalizer
     refrence handler
     signal dispatcher
     attach listner
===> ThreadGroup is a java class persent in java.lang package and it is the direct child class of object.

===>Constructors:
                1.ThreadGroup g = new ThreadGroup(String groupname)
                   ThreadGroup g = new ThreadGroup("firstGroup"); //
                1.ThreadGroup g = new ThreadGroup(ThreadGroup pg,String groupname);
                   ThreadGroup g = new ThreadGroup(g, secondgroup);

===>Important methods of ThreadGroup class:
    1. String getName();
    2. int getMaxPriority();
    3. void setMaxPriority();
    4 ThreadGroup getParent()
    5.void list();
    6.int activeCount(); // its count thread in group
    7.int activeGroupCount(); // its count subGroupThread in group
    8 int enumerate(Thread[] t)// to copy all active thread of this thread group into provided thread array.
      g1.enumerate(Thread[] t) //   in this case subThreadGroup threads also will be considered.

    9 int enumerate(ThreadGroup[] g)// to copy all active subThreadGroups into ThreadGroup array.
    10. boolean isDaemon() // to check ThreadGroup is Daimon or not
    11. void setDaemon(boolean b)//
    12. void interrupt()// to interrupt all waiting or sleeping threads persent in the ThreadGroup
    13. void destroy()// to destroy ThreadGroup and its subThreadGroups

Q1. write a program to display all active thread name belongs to system group and its child group.

 */