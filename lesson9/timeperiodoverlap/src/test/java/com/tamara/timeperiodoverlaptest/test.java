package com.tamara.timeperiodoverlaptest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@RunWith(JUnit4.class)
public class test {
    private TimePeriod timeperiod=new TimePeriod(LocalTime.of(1, 30, 45),LocalTime.of(10, 30, 45));
    @Test
    public void testOverlap() throws Exception
    {
        boolean result =this.timeperiod.overlapsWith(new TimePeriod(LocalTime.of(4, 30, 45),LocalTime.of(5, 30, 45)));
        Assert.assertEquals(true,result);

    }
    @Test
    public void testOverlaponBorder() throws Exception
    {
        boolean result =this.timeperiod.overlapsWith(new TimePeriod(LocalTime.of(1, 30, 45),LocalTime.of(10, 30, 45)));
        Assert.assertEquals(true,result);

    }
    @Test
    public void testleft() throws Exception
    {
        boolean result =this.timeperiod.overlapsWith(new TimePeriod(LocalTime.of(0, 30, 45),LocalTime.of(1, 30, 44)));
        Assert.assertEquals(false,result);

    }
    @Test
    public void testOverlapleftPart() throws Exception
    {
        boolean result =this.timeperiod.overlapsWith(new TimePeriod(LocalTime.of(1, 30, 45),LocalTime.of(5, 30, 45)));
        Assert.assertEquals(true,result);

    }
    @Test
    public void testOverlapRightPart() throws Exception
    {
        boolean result =this.timeperiod.overlapsWith(new TimePeriod(LocalTime.of(5, 30, 45),LocalTime.of(10, 30, 45)));
        Assert.assertEquals(true,result);

    }
    @Test
    public void testOverlapNullFirstPeriod()
    {
        boolean result =this.timeperiod.overlapsWith(new TimePeriod(null,LocalTime.of(5, 30, 45)));
        Assert.assertEquals(false,result);
    }
    @Test
    public void testOverlapNullSecondPeriod()
    {
        boolean result =this.timeperiod.overlapsWith(new TimePeriod(LocalTime.of(5, 30, 45),null));
        Assert.assertEquals(false,result);
    }
    @Test
    public void TestOverlapNull()
    {
        boolean result =this.timeperiod.overlapsWith(null);
        Assert.assertEquals(false,result);
    }


}
