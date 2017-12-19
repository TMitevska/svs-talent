package com.ventoelectrics.waterheater;

import com.acme.thermoregulator.EfficientThermoregulator;
import com.acme.thermoregulator.StandardThermoregulator;
import com.acme.thermoregulator.Thermoregulator;
import com.ventoelectrics.heater.Heater;
import com.ventoelectrics.powerswitch.PowerSwitch;
import com.ventoelectrics.thermometer.Thermometer;

import java.util.concurrent.TimeUnit;

public class WaterHeaterApplication {

    public static void main(String[] args) throws Exception {
        PowerSwitch powerSwitch = new PowerSwitch();
        Heater heater = new Heater();
        Thermometer thermometer = new Thermometer();
        Thermoregulator thermoregulator = new StandardThermoregulator(); // Standard or efficient thermoregulator.

        WaterHeater waterHeater = new WaterHeater(powerSwitch, heater, thermometer, thermoregulator);

        simulateRun(waterHeater);
    }

    private static void simulateRun(WaterHeater waterHeater) {
        System.out.println("simulate run");
        waterHeater.getThermoregulator().setTemperature(20);
        waterHeater.getPowerSwitch().turnOn();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
        }
        waterHeater.getThermoregulator().run(waterHeater.getHeater(), waterHeater.getThermometer());
        waterHeater.getThermoregulator().setTemperature(40);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
        }
        waterHeater.getThermoregulator().run(waterHeater.getHeater(), waterHeater.getThermometer());
        waterHeater.getPowerSwitch().turnOff();
    }
}
