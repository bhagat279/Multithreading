package interview;


class FlagChecker {
    // Using 'volatile' ensures that the change to 'flag' is immediately visible to all threads
    private volatile boolean flag = false;

    public void setFlagTrue() {
        System.out.println("flag is true by thread-1");
        flag = true;

    }

    public void printIfFlagTrue() {
        while (!flag) {
            //
        }
        System.out.println("flag is true");
    }
}

public class VolatileExample {
    public static void main(String[] args) throws InterruptedException {

        FlagChecker flagChecker = new FlagChecker();

        // Thread that sets the flag to true after 2 seconds
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                flagChecker.setFlagTrue();
            } catch (InterruptedException ignored) {
            }
        });


        Thread thread2 = new Thread(flagChecker::printIfFlagTrue);


        thread1.start();
        thread2.start();

    }
}
