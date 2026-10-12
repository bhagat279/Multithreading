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
            notify();
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
✅ Kyunki tumhe ye guarantee chahiye ki us waqt tum us object ka monitor lock hold kar rahe ho.
✅ Ye monitor lock hi wait() aur notify() ke proper kaam karne ke liye zaroori hai.
✅ Without lock, wait() aur notify() safe nahi hai (race condition ho jayegi).

import java.util.LinkedList;
import java.util.Queue;

class SharedQueue {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int CAPACITY = 2;

    public void produce(int value) throws InterruptedException {
        synchronized (this) {  // monitor lock liya
            while (queue.size() == CAPACITY) {
                System.out.println("Queue full hai, producer wait karega...");
                wait(); // monitor lock chhod ke wait me chala jaega
            }
            queue.add(value);
            System.out.println("Produced: " + value);
            notify(); // consumer ko jagao
        } // synchronized se bahar nikla to lock release
    }

    public void consume() throws InterruptedException {
        synchronized (this) {  // monitor lock liya
            while (queue.isEmpty()) {
                System.out.println("Queue empty hai, consumer wait karega...");
                wait(); // monitor lock chhod ke wait me chala jaega
            }
            int val = queue.poll();
            System.out.println("Consumed: " + val);
            notify(); // producer ko jagao
        }
    }
}

class Producer implements Runnable {
    private SharedQueue queue;

    public Producer(SharedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int value = 0;
        try {
            while (true) {
                queue.produce(value);
                value++;
                Thread.sleep(500); // thoda delay
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private SharedQueue queue;

    public Consumer(SharedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                queue.consume();
                Thread.sleep(1000); // thoda delay
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SharedQueue sharedQueue = new SharedQueue();

        Thread producerThread = new Thread(new Producer(sharedQueue));
        Thread consumerThread = new Thread(new Consumer(sharedQueue));

        producerThread.start();
        consumerThread.start();
    }
}

 */