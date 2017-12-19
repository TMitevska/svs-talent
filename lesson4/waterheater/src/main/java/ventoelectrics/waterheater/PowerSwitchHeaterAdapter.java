package ventoelectrics.waterheater;


import ventoelectrics.heater.Heater;
import ventoelectrics.powerswitch.PoweredDevice;
import ventoelectrics.heater.heater;
public class PowerSwitchHeaterAdapter implements PoweredDevice,heater {
    private Heater heater;
    PowerSwitchHeaterAdapter(Heater heater){this.heater=heater;}
    public void enablePower(){heater.turnOn();}
    public void disablePower(){heater.turnOff();}
    public void startHeating(){heater.startHeating();}
    public void stopHeating(){heater.stopHeating();}


}
