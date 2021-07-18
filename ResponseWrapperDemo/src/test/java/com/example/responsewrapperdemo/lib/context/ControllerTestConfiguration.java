package com.example.responsewrapperdemo.lib.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Emil Nasyrov (Emilikan)
 */

@Configuration
@ComponentScan(value = "com.example.responsewrapperdemo", lazyInit = true)
public class ControllerTestConfiguration {

}
