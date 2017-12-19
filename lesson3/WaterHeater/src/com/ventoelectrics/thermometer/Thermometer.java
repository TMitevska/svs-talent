package com.ventoelectrics.thermometer;

import com.ventoelectrics.powerswitch.PoweredDevice;
import com.ventoelectrics.heater.NoPowerException;

import java.util.Random;

public class Thermometer {

    private boolean powerEnabled = false;

    private Random random = new Random(System.currentTimeMillis());

    public Integer getTemperature() {
        if (!powerEnabled) {
            throw new NoPowerException();
        }
        return random.nextInt(60);
    }

    public void turnOn() {
        powerEnabled = true;
    }

    public void turnOff() {
        powerEnabled = false;
    }
}
