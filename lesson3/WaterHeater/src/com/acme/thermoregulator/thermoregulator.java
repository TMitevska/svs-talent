package com.acme.thermoregulator;

import com.ventoelectrics.heater.Heater;
import com.ventoelectrics.thermometer.Thermometer;

public interface thermoregulator {
    void run();
    void setTemperature(int temp);
}
