package ventoelectrics.waterheater;

import acme.thermoregulator.StandardThermoregulator;
import acme.thermoregulator.Thermoregulator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import ventoelectrics.heater.Heater;
import ventoelectrics.powerswitch.PowerSwitch;
import ventoelectrics.thermometer.Thermometer;

@Configuration
@Profile("standard")
public class AppConfiguration1 {
    @Bean Thermometer thermometer(){return new Thermometer();}
    @Bean Heater heater(){return new Heater();}
    @Bean Thermoregulator thermoregulator(){return new StandardThermoregulator();}
    @Bean PowerSwitch powerswitch(){return new PowerSwitch();}

    @Bean PowerSwitchThermometerAdapter thermometeradapter(){return new PowerSwitchThermometerAdapter(thermometer());}
    @Bean PowerSwitchHeaterAdapter heateradapter(){return new PowerSwitchHeaterAdapter(heater());}
    @Bean PowerSwitchThermoregulatorAdapter thermoregulatoradapter(){return new PowerSwitchThermoregulatorAdapter(thermoregulator(),heater(),thermometer());}

    @Bean WaterHeater waterheater(){return new WaterHeater(powerswitch(),heater(),thermometer(),thermoregulator());}

}
