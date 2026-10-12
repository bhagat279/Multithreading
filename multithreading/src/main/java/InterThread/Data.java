package InterThread;

public class Data {
    int value;
    boolean flag = false;

    //Producer method
    synchronized void produce(int val) {
        try {
            if (flag == true) {
                wait();
            }
            value = val;
            System.out.println("produced: " + value);
            flag = true;// now data persent
            notify();// notify to consumer
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //consumer method
    synchronized void consume()
    {
        try{
            if (flag == false)
            {
                wait();
            }
            System.out.println("consumed: "+ value);
            flag = false;// data consumed
            notify();// notify t0 producer
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

