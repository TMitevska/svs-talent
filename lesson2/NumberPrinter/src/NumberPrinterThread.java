public class NumberPrinterThread extends Thread{
    private int num;
    NumberPrinterThread(int n){this.num=n;}
    public void run()
    {
        for(int i=1;i<this.num;i++)
        {  if(Thread.interrupted()){System.out.println("Thread interrupted");return;}
            System.out.print(i+"  ");
        }

        System.out.println("Thread finished printing");

    }
}
