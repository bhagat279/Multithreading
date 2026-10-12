package Thread;

class MyYield extends Thread
{
    public void run()
    {
        Thread.yield();
        for(int i=1;i<=3;i++)
        {
            System.out.println(Thread.currentThread().getPriority()+"child-yield");

        }
    }
}

public class Yieldd {
    public static void main(String[] args) {

        MyYield my = new MyYield();
        my.setPriority(2);
        my.start();


        for(int i=1;i<=3;i++)
        {
            System.out.println(Thread.currentThread().getPriority()+"main");
            //Thread.yield();
        }

    }
}
/*
===> We can prevent thread execution using below methods
    1. yield()
    2. join()
    3. sleep()


===>yield(): It pause current executing thread to give the chance for other waiting threads of same priority/high.
             If there is no waiting threads or all waiting threads have low priority, then same thread can continue
             its execution.


===> If multiple threads are waiting with same priority, then which waiting thread will get chance we can not expect
     it depends on T.S.

===> The thread  which we use Thread.yield() method, it will go to waiting state and when it will get chance once again
     its depend on T.S.

===> Some plateform/operating system does not provide support to yield() method, so output may be vary

 */
//============================================================================================================
/*
✨ 1. Thread.yield() kya karta hai?
✅ Ye static method hai jo current thread ko hint deta hai ki:

“Mere paas CPU hai, lekin main voluntarily chhod raha hoon.
Agar koi aur thread ready hai (same priority or higher priority), to usko run kara do.”

📌 Important:

Ye sirf hint hai, guarantee nahi ki turant dusra thread run karega.

Jo thread yield kar raha hai wo bhi phir se runnable ho jata hai (ready state me chala jata hai).

✨ 2. Thread Priority ke sath use
Java me threads ke liye 3 predefined priorities hoti hain (aur tum custom bhi de sakte ho):

Thread.MIN_PRIORITY = 1

Thread.NORM_PRIORITY = 5 (default)

Thread.MAX_PRIORITY = 10

👉 Scheduler zyada priority wale threads ko pehle chalane ki koshish karta hai (but again, guarantee nahi, depends on OS scheduler).

✅ 3. Example with yield() and priority
💻 Code:
java
Copy
Edit
class MyYieldThread extends Thread {
    public MyYieldThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " : " + i);
            if (i == 3) {
                System.out.println(getName() + " is yielding...");
                Thread.yield();
            }
        }
    }
}

public class YieldPriorityDemo {
    public static void main(String[] args) {
        MyYieldThread t1 = new MyYieldThread("LowPriorityThread");
        MyYieldThread t2 = new MyYieldThread("HighPriorityThread");

        // Priority set karo
        t1.setPriority(Thread.MIN_PRIORITY); // 1
        t2.setPriority(Thread.MAX_PRIORITY); // 10

        t1.start();
        t2.start();
    }
}
🔥 Expected Output (but may vary):
yaml
Copy
Edit
LowPriorityThread : 1
LowPriorityThread : 2
LowPriorityThread : 3
LowPriorityThread is yielding...
HighPriorityThread : 1
HighPriorityThread : 2
HighPriorityThread : 3
HighPriorityThread is yielding...
HighPriorityThread : 4
HighPriorityThread : 5
LowPriorityThread : 4
LowPriorityThread : 5
👉 Kya dekhne ko milega?

Jab LowPriorityThread 3 pe yield karega, scheduler ko hint milega: “koi aur ready hai to chala do”.

High priority thread ready hai → CPU usko mil jata hai.

Phir HighPriorityThread run karta hai aur apna kaam karta hai.

✅ 4. Key Points
✔️ yield():

Hint to scheduler.

Current thread ko runnable me bhej deta hai, dusra ready thread ko chance mil sakta hai.

✔️ Priority:

Scheduler zyada priority wale threads ko prefer karega.

Par Java me koi hard guarantee nahi hai (depends on JVM/OS).

✅ 5. Jab use kare?
Jab tumhe ek long running thread ke beech me dusre threads ko bhi CPU ka chance dena ho.

Example: background calculation karte waqt UI thread ko starve mat hone do.
 */