package ventoelectrics.waterheater;

import ventoelectrics.powerswitch.PoweredDevice;
import ventoelectrics.thermometer.Thermometer;
import ventoelectrics.thermometer.thermometer;
public class PowerSwitchThermometerAdapter implements PoweredDevice, thermometer {
    private Thermometer thermometer;
    PowerSwitchThermometerAdapter(Thermometer thermometer){this.thermometer=thermometer;}

    public void enablePower(){thermometer.turnOn();}

    public void disablePower(){thermometer.turnOff();}

    public int getTemperature(){return thermometer.getTemperature();}



}
