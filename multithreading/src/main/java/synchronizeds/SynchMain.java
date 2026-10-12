package synchronizeds;

public class SynchMain {
    public static void main(String[] args) {
        Display d = new Display();
        Display d2 = new Display();
        MyThread1 t1 = new MyThread1(d,"ravi");
        MyThread1 t2 = new MyThread1(d2,"bhagat");
        t1.start();
        t2.start();

    }

}
