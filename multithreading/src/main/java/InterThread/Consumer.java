package InterThread;

public class Consumer extends Thread{
    Data d;
    Consumer(Data d)
    {
        this.d =d;
    }
    public void run()
    {
        for(int i= 1; i<=5;i++)
        {
            d.consume();
            try
            {
                Thread.sleep(1000);
            }catch (Exception e)
            {

            }
        }
    }
}
