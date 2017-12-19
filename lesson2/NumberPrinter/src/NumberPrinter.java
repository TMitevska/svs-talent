public class NumberPrinter {
    public static void main(String[] argc)
    {
       NumberPrinterThread thread=new NumberPrinterThread(Integer.parseInt(argc[0]));
       thread.start();
       try{
           long value=Long.parseLong(argc[1]);
           System.out.println(value*1000);
           thread.join(value);
           if(thread.isAlive()){thread.interrupt();}
       }
       catch(InterruptedException e)
       {
           System.out.println("Thread interrupted");
       }

    }
}
