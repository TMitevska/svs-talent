public class StopWatchThread extends Thread {
    public int time;
    public int timebefore;
    StopWatchThread(){time=0;}
    StopWatchThread(int a){timebefore=a;time=0;}
    public void run()
    { int second=0;
      this.time=0;
      long start=System.currentTimeMillis();
        while(true)
        {
            long end=System.currentTimeMillis();
            long duration=end-start;
            time=second;
            if((duration/1000)>second){second=(int)(duration/1000);System.out.println(second+timebefore);}


            if(Thread.interrupted()){
                time=time+timebefore;
                for(int i=0;i<100;i++){}
                return;
            }
        }

    }
    public int gettime()
    {
        return this.time;
    }

}

