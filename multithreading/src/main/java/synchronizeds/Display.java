package synchronizeds;

public class Display {
    //public  synchronized void wish(String name)
    public static synchronized void wish(String name)
    {
       for(int i=1;i<=5;i++)
       {
           System.out.print("gd morning: ");
           try{
               Thread.sleep(1000);
           }catch (Exception e)
           {

           }
           System.out.println(name);
       }
    }

}
