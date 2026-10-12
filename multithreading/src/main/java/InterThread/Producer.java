package InterThread;

public class Producer extends Thread{
    Data d;
    Producer(Data d)
    {
        this.d = d;
    }
    public void run()
    {
        for(int i =1;i<=5;i++)
        {
            d.produce(i);
            try
            {
                Thread.sleep(500);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
