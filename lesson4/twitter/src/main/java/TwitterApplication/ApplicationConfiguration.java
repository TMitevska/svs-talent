package TwitterApplication;

import Messages.Messages;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean Messages messages(){return new Messages();}

}
