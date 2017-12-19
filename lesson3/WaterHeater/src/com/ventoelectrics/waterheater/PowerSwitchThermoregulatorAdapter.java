package com.ventoelectrics.waterheater;

import com.acme.thermoregulator.Thermoregulator;
import com.ventoelectrics.heater.Heater;
import com.ventoelectrics.powerswitch.PoweredDevice;
import com.ventoelectrics.thermometer.Thermometer;
import com.acme.thermoregulator.thermoregulator;

public class PowerSwitchThermoregulatorAdapter implements PoweredDevice,thermoregulator{
   private Thermoregulator thermoregulator;
   private Heater heater;
   private Thermometer thermometer;
   public PowerSwitchThermoregulatorAdapter(Thermoregulator thermoregulator,Heater heater,Thermometer thermometer){this.thermoregulator=thermoregulator;this.heater=heater;this.thermometer=thermometer;}
    @Override
    public void enablePower(){thermoregulator.turnOn();}
    @Override
    public void disablePower(){thermoregulator.turnOff();}
    @Override
    public void setTemperature(int temperature){thermoregulator.setTemperature(temperature);}
    @Override
    public void run(){thermoregulator.run(heater,thermometer);}


}
