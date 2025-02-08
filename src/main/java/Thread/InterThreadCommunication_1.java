package Thread;

public class InterThreadCommunication_1 {
    public static void main(String[] args) {


    }
}
/*
===> 2 threads can communicate with each other by using below methods:
     1. wait()
     2. notify()
     3. notifyAll()

     The thread which is expecting updation is responsible to call wait() method, then immediately thread will
     entered into wait state

     The thread which is responsible to perform operation, after performing operation it is responsible to call
     notify() method, then waiting thread will get that notification, and continue its execution with those updated
     items.

Q1: why wait(),notify and notifyAll, all methods are persent in Object class but not in Thread class?
===> Because thread can call these methods on any java object.

===> To call wait(). notify() and notifyAll() methods on any object, thread should be owner of that object that is
    thread should has lock of that object, that is thread should be inside synchronized are.
    Hence we can call wait(), notify() and notifyAll() methods only from synchronized are, otherwise we get runtime exception
    saying "IllegalMonitorStateException"

===> If a thread calls wait() method on any object it immediately releases the lock of that particular object and
     entered into waiting state.

===> If a thread calls notify() method on any object, it releases the lock of that object but may not immediately
     except wait(), notify() and notifyAll() method, there is no other method where thread releases the lock.

====> Various loop holes
1    If a thread calls wait() method on any object it releases all locks acquired by that thread and immediately entered
     into waiting state.(False)

2    If a thread calls wait() method on any object it immediately releases the lock of particular object and entered into
     waiting state.(true)

3    If a thread calls notify() method on any object it immediately releases the lock of particular object.(false)

4    If a thread calls notify() method on any object it releases the lock of that object but may not immediately.(true)

====> All wait methods(), notify() and notifyAll()
     1. public final void wait(); throws inturrptedException
     2. public final void wait(Long ms);throws inturrptedException
     3. public final void wait(Long ms,int ns); throws inturrptedException


     5. public final native void notify();
     6. public final native void notifyAll();


 */