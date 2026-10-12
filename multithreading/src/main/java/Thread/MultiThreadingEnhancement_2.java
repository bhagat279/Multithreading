package Thread;

public class MultiThreadingEnhancement_2 {

}

/*
java.util.concurrent:

===> Problems with synchronized keyword
    1. We are not having any flexibility to try for a lock, without waiting.
    2. There is no way to specify maximum waiting time for a thread to get lock, so that thread will wait until
      getting the lock, which may creates performance problems, which may cause deadlock.

    3. If a thread release a lock, then which waiting thread will get that lock we are not having any control on this.
    4. There is no API to list out all waiting threads for a lock.
    5. synchronized keyword compulsory we have to use either at method level or within the method and its not possible
       to use across multiple methods.
       To overcome these problems sun peoples introduce java.util.concurrent.locks package in 1.5 version.

    6. Its also provide several's enhancement to the programmer to provide more control on the concurrency.

    7. Lock(I) interface:
       Lock object is similar to implicit lock acquired by a thread to execute synchronized method or synchronized block
       Lock implementation provide more extensive operation than traditional implicit locks.


    8. Important methods of lock interface:

       1. void lock();
         we can use this method to acquire a lock, if lock is already applicable then immediatly current thread will
         get that lock, if it is not already available then it will wait until getting the lock, it is exactly same behavior
         of traditional synchronized keyword.

       2. boolean tryLock();
          to acquired the lock without waiting, if the lock is available then the thread acquired that lock
          and return true, if the lock is not available then this method returns false, and can continue its execution
          without waiting, in this case thread never be entered into waiting state.

          i(l.tryLock())
          {
            perform safe operations
          }
          else
          {
            perform alternative opeations
          }

       3. boolean tryLock(long time, TimeUnit unit)
          if the lock is available, then the thread will get the lock and contioue its execution.
          If lock not available then thread will wait until specified amount of time, still
          if lock is not available then thread can continue its execution.



       enum TimeUnit
       {
         NANOSECONDS
         MICROSECONDS
         MILISECONDS
         MINUTES
         HOURS
         DAYS
       }

       if(l.tryLock(1000, TimeUnit miliseconds))
       {
       }

      4. void lockInterruptibly()
         thread acquire the lock if it is available and returns immedaitly.
         if lock is not available then it will wait, while waiting if the thread is interrupted then thread dont get
         the lock,

      5. void unlock();
        to release the lock.
        To call this method compulsory current thread should be owner of the lock, otherwise we will get runtime exception
        "IllegalMonitorStateException"

 */