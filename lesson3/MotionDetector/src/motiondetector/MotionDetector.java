package motiondetector;

import alarmchanel.AlarmChanel;
import imagecapturingdevice.ImageCapturingDevice;

import java.io.IOException;

public class MotionDetector implements Motiondetector{
    private boolean running;
    private String previousImage;
    private boolean firstImage;
    MotionDetector(){this.running=true;this.firstImage=true;this.previousImage="";}
    @Override
    public void start()
    {
        while(running)
        {
            String newimage=new ImageCapturingDevice().capture();
            if(firstImage){System.out.println("This was your first image");this.firstImage=false;}
            else
                {
                    boolean result=compare(previousImage,newimage);
                    if(result==false)
                    {
                        AlarmChanel alarm=new AlarmChanel();
                        alarm.triggerAlarm();
                    }
                }

            previousImage=newimage;
            try{
            Thread.sleep(1000);}
            catch(InterruptedException e){}
        }
    }
    @Override
    public boolean compare(String firstImage,String secoundImage)
    {
        if(firstImage.equals(secoundImage))
        {
            return true;
        }
        else
        { return false;}
    }
}
