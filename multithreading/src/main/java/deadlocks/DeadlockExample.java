package deadlocks;

public class DeadlockExample {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        // Thread 1
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: holding lock 1...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                System.out.println("Thread 1: waiting for lock 2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: holding lock 1 & 2...");
                }
            }
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: holding lock 2...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                System.out.println("Thread 2: waiting for lock 1...");
                synchronized (lock1) {
                    System.out.println("Thread 2: holding lock 2 & 1...");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
/*

👉 Aur yahin par dono forever block ho jaate hain.
Kyuki:

Thread 1 kabhi lock2 nahi le paata (Thread2 ne pakad rakha hai)

Thread 2 kabhi lock1 nahi le paata (Thread1 ne pakad rakha hai)

💥 Result: DEADLOCK



 */
