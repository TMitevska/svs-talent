package com.tamara.timeperiodoverlaptest;

import java.time.LocalTime;

public class TimePeriod  {
    private LocalTime x;
    private LocalTime y;
    TimePeriod(){}
    TimePeriod(LocalTime a,LocalTime b){this.x=a;this.y=b;}
    public boolean overlapsWith(TimePeriod period)
    {

        if(period==null)
        {

            return false;
        }
        else if(period.x==null)
        {
            return false;
        }
        else if(period.y==null)
        {
            return false;
        }
        else if((this.x.isBefore(period.y) && this.y.isAfter(period.x)) || (this.x.equals(period.y) && this.y.equals(period.x)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
