package synchronizeds;

public class MyThread1 extends Thread{
    Display d;
    String name;
    MyThread1(Display d,String name)
    {
        this.d=d;
        this.name=name;
    }
    public void run()
    {
        d.wish(name);
    }
}
