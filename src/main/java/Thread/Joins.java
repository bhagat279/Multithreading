package Thread;

class MyJoin extends Thread {
    static Thread thread;
   /* public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("child-join");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {

            }
        }
    }*/

    public void run() {
        for (int i = 1; i <= 5; i++) {

            try {
                thread.join();
            } catch (Exception e) {

            }
            System.out.println("child thread");
        }
    }

}

public class Joins {
    public static void main(String[] args) throws InterruptedException {

        MyJoin.thread = Thread.currentThread();

        MyJoin mj = new MyJoin();
        mj.start();

       //  mj.join();
        // mj.join(2000);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Main-Thread");
        }

      //  Thread.currentThread().join();

    }
}

/*

join()===> If a thread wants to wait untill completing of some other thread then we should go for join() method.
          If thread T1 wants to wait untill completing T2, then T1 has to call T2.join().

          If T1 executes T2.join, then immediatlly T1 will be enterd into waiting state, until T2 complets.
          Once T2 complete, T1 can continoue its execution.

===> There 3 join() methods overloaded
    public final void join() throws InterupptedExeption
    public final void join(long ms) throws InterupptedExeption
    public final void join(long ms,int ns) throws InterupptedExeption

===> If we call join() method in both class then It will go to Deadlock condition

===>If we use join() method on same thread then It will go to deadlock condition
     Thread.currentThread().join();

 */