public class Watch {
    private int time;
    StopWatchThread thread;
    Watch(){time=0;}
    public void start()
    {   thread=new StopWatchThread(time);
        thread.start();
    }
    public void pause()
    {
        time=time+thread.gettime();
        thread.interrupt();

    }
    public void resume()
    {
        thread=new StopWatchThread(time);
        thread.start();
    }
    public void stop()
    {  if(thread.isAlive()){time=time+thread.gettime();thread.interrupt();}
        System.out.println("Stopwatch was counting "+time+" seconds");
    }

    public long gettime()
    {return this.time;}
}
