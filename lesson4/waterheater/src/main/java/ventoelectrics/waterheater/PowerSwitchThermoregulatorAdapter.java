package ventoelectrics.waterheater;


import acme.thermoregulator.Thermoregulator;
import ventoelectrics.heater.Heater;
import acme.thermoregulator.thermoregulator;
import ventoelectrics.powerswitch.PoweredDevice;
import ventoelectrics.thermometer.Thermometer;

public class PowerSwitchThermoregulatorAdapter implements PoweredDevice,thermoregulator{
   private Thermoregulator thermoregulator;
   private Heater heater;
   private Thermometer thermometer;
   public PowerSwitchThermoregulatorAdapter(Thermoregulator thermoregulator,Heater heater,Thermometer thermometer){this.thermoregulator=thermoregulator;this.heater=heater;this.thermometer=thermometer;}
    public void enablePower(){thermoregulator.turnOn();}

    public void disablePower(){thermoregulator.turnOff();}

    public void setTemperature(int temperature){thermoregulator.setTemperature(temperature);}
    public void run(){thermoregulator.run(heater,thermometer);}


}
