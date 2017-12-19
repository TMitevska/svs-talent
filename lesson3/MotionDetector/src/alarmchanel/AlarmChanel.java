package alarmchanel;

public class AlarmChanel implements Alarm {
   public  AlarmChanel(){}
    @Override
    public void triggerAlarm()
    {
       System.out.println("Alarm");
    }
}
