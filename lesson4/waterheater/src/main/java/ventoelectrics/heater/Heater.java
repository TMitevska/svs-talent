package ventoelectrics.heater;


public class Heater {

    private boolean powerEnabled = false;


    public void turnOn() {
        powerEnabled = true;
    }

    public void turnOff() {
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
