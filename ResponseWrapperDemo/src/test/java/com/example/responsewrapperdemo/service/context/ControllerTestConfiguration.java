package com.example.responsewrapperdemo.service.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Emil Nasyrov (Emilikan)
 */

@Configuration
@ComponentScan(value = "com.example.responsewrapperdemo.service", lazyInit = true)
public class ControllerTestConfiguration {

}
