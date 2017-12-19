package com.ventoelectrics.waterheater;

import com.acme.thermoregulator.StandardThermoregulator;
import com.acme.thermoregulator.Thermoregulator;
import com.ventoelectrics.heater.Heater;
import com.ventoelectrics.powerswitch.PowerSwitch;
import com.ventoelectrics.thermometer.Thermometer;

public class WaterHeater {

    private PowerSwitch powerSwitch;

    private Heater heater;

    private Thermometer thermometer;

    private Thermoregulator thermoregulator;

    public WaterHeater(PowerSwitch powerSwitch, Heater heater, Thermometer thermometer, Thermoregulator thermoregulator) {
        this.powerSwitch = powerSwitch;
        this.heater = heater;
        this.thermometer = thermometer;
        this.thermoregulator = thermoregulator;

        this.powerSwitch.controlPowerFor(new PowerSwitchHeaterAdapter(heater));
        this.powerSwitch.controlPowerFor(new PowerSwitchThermometerAdapter(thermometer));
        this.powerSwitch.controlPowerFor(new PowerSwitchThermoregulatorAdapter(thermoregulator,heater,thermometer));
    }

    public PowerSwitch getPowerSwitch() {
        return powerSwitch;
    }

    public Thermoregulator getThermoregulator() {
        return thermoregulator;
    }

    public Heater getHeater() {
        return heater;
    }

    public Thermometer getThermometer() {
        return thermometer;
    }
}
