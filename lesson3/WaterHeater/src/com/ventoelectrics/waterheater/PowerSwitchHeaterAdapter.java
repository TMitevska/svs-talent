package com.ventoelectrics.waterheater;

import com.ventoelectrics.heater.Heater;
import com.ventoelectrics.heater.heater;
import com.ventoelectrics.powerswitch.PoweredDevice;

public class PowerSwitchHeaterAdapter implements PoweredDevice,heater {
    private Heater heater;
    PowerSwitchHeaterAdapter(Heater heater){this.heater=heater;}
    @Override
    public void enablePower(){heater.turnOn();}
    @Override
    public void disablePower(){heater.turnOff();}
    @Override
    public void startHeating(){heater.startHeating();}
    @Override
    public void stopHeating(){heater.stopHeating();}


}
