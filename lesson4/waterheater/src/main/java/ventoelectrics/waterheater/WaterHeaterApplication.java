package ventoelectrics.waterheater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.concurrent.TimeUnit;
@SpringBootApplication
public class WaterHeaterApplication {

    public static void main(String[] args) throws Exception {
        System.setProperty("spring.profiles.active", "efficient");
        AbstractApplicationContext ctx = (AbstractApplicationContext) SpringApplication.run(WaterHeaterApplication.class, args);
        ctx.registerShutdownHook();
        WaterHeater waterHeater = ctx.getBean(WaterHeater.class);

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
