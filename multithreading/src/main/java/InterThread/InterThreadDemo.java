package InterThread;

public class InterThreadDemo {
    public static void main(String[] args) {
        Data d = new Data();
        Producer p = new Producer(d);
        Consumer c = new Consumer(d);
        p.start();
        c.start();
    }
}
