
public class Heater implements PoweredDevice {

    private boolean powerEnabled = false;


    public void enablePower() {
        powerEnabled = true;
    }

    public void disablePower() {
        powerEnabled = false;
    }

    public void startHeating() {
        if (!powerEnabled) {
            throw new NoPowerException();
        }
        System.out.println("Heater.startHeating()");
    }

    public void stopHeating() {
        System.out.println("Heater.stopHeating()");
    }
}
