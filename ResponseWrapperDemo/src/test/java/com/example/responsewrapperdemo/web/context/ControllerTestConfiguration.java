package com.example.responsewrapperdemo.web.context;

import com.example.responsewrapperdemo.web.Controller;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * @author Emil Nasyrov (Emilikan)
 */

@TestConfiguration
public class ControllerTestConfiguration {

    @Bean
    public Controller controller() {
        return new Controller();
    }

}
