package SreyanshJain;

import java.util.concurrent.*;

class MySumTask extends RecursiveTask<Long> {
    private final int[] arr;
    private final int start;
    private final int end;
    private static final int THRESHOLD = 3;

    public MySumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if ((end - start) <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            MySumTask leftTask = new MySumTask(arr, start, mid);
            MySumTask rightTask = new MySumTask(arr, mid, end);

            // ✅ left & right dono fork karo
            leftTask.fork();
            rightTask.fork();

            // ✅ dono ko join karo (parallel results leke combine karna)
            long leftResult = leftTask.join();
            long rightResult = rightTask.join();

            return leftResult + rightResult;
        }
    }
}

public class ForkJoinBothFork {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};


        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Future<Long> submit = forkJoinPool.submit(new MySumTask(arr, 0, arr.length));

        System.out.println("Sum = " + submit.get());



    }
}

/*
Agar thread pool me 2 Thread hai, to dono ke pas apna dequeue(work stealing pool) hoga,
suppose 2 task aya, 1 task thread-1 ko aur 2nd task thread-2 ko assign hua
each thread apna task ko subtask me devide krke apne dequeue me rakh lega aur execute karega
sbse phle apna dequeue ka task complete krega phir , SUBMISSION QUEUE ka last me
dusre Thread se Task steal karega kyoki sabhi thread DEQUEUE use krte hai, jo dono taraf se open rhta hai

 */
/*

newWorkStealingPool(n) internally ek ForkJoinPool banata hai jisme n worker threads hote hain.

Har thread ka apna deque (double-ended queue) hota hai jisme wo apne subtasks rakhta hai.

Jab ek thread ke pass kaam khatam ho jata hai, to wo dusre thread ke deque se task steal karta hai (isliye naam: work stealing).

Agar tu 4 de raha hai, matlab ek waqt me max 4 subtasks parallel run kar sakte ho (agar CPU cores available ho).

⚡ Example:

Array sum karne wale case me agar tu arr ko tod raha hai, to 4 threads alag-alag parts ka sum parallel nikalenge.

Agar 2 deta → max 2 threads hi parallel chalenge.

Agar machine ke paas 8 logical cores hain aur tu 8 deta → aur jyada parallelism milega.
 */