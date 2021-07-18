package com.example.responsewrapperdemo.web.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Emil Nasyrov (Emilikan)
 */

@Configuration
@ComponentScan(value = "com.example.responsewrapperdemo.web", lazyInit = true)
public class ControllerTestConfiguration {

}
