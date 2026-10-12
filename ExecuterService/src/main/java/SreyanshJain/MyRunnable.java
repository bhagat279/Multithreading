package SreyanshJain;

import java.util.List;

public class MyRunnable implements Runnable{

    List<Integer> list;
    MyRunnable(List<Integer> list)
    {
        this.list=list;
    }

    @Override
    public void run() {
        // It has to do some work
        list.add(10);
        list.add(20);
        list.add(30);
    }
}
