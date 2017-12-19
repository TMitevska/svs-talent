package com.acme.thermoregulator;


import com.ventoelectrics.powerswitch.PoweredDevice;
import com.ventoelectrics.heater.Heater;
import com.ventoelectrics.thermometer.Thermometer;

public class Thermoregulator  {
    private boolean running;
    Thermometer thermometer;
    private boolean powerEnabled = false;
    private int temperature;
    Heater heater;
    private int delay;

    public Thermoregulator(int delay) {
        this.delay = delay;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
        System.out.println("Temperature is " + temperature + " degrees");
    }

    public void run(Heater heater, Thermometer thermometer) {
        this.heater = heater;
        this.thermometer = thermometer;
        this.running = true;
        while (running) {
            int currentTemperature = thermometer.getTemperature();
            System.out.println("Current temperature is " + currentTemperature);
            if (currentTemperature > temperature) {
                System.out.println("Stop heating");
                heater.stopHeating();

            } else {
                System.out.println("start heating");
                heater.startHeating();
            }


            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
            }
            break;
        }
    }

    public void turnOn() {
        powerEnabled = true;
    }

    public void turnOff() {
        powerEnabled = false;
    }
}


