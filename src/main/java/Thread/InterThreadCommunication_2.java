package Thread;

class ThreadA extends Thread
{
    int total=0;
    public void run()
    {
        synchronized (this) {
            System.out.println("child thread starts calculation");
            for (int i = 1; i <= 5; i++) {
                total = total + i;
            }
            System.out.println("child thread trying to give notification ");
            this.notify();
        }
    }
}
public class InterThreadCommunication_2 {
    public static void main(String[] args) throws InterruptedException {

        ThreadA ta = new ThreadA();
        ta.start();

        Thread.sleep(1000);
        synchronized (ta)
        {
            System.out.println("main thread trying to call wait method");
            //ta.wait();// main thread will go to waiting state
            ta.wait(5000);
            System.out.println("main thread got notification");
            System.out.println(ta.total);
        }

    }
}
/*
===>


 */