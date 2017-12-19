package com.ventoelectrics.waterheater;

import com.ventoelectrics.powerswitch.PoweredDevice;
import com.ventoelectrics.thermometer.Thermometer;
import com.ventoelectrics.thermometer.thermometer;

public class PowerSwitchThermometerAdapter implements PoweredDevice, thermometer {
    private Thermometer thermometer;
    PowerSwitchThermometerAdapter(Thermometer thermometer){this.thermometer=thermometer;}
    @Override
    public void enablePower(){thermometer.turnOn();}
    @Override
    public void disablePower(){thermometer.turnOff();}
    @Override
    public int getTemperature(){return thermometer.getTemperature();}



}
