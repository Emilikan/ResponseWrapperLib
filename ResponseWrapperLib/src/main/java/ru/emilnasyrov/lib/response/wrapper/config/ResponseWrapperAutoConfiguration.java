package ru.emilnasyrov.lib.response.wrapper.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import ru.emilnasyrov.lib.response.wrapper.advice.ResponseWrapperAdvice;
import ru.emilnasyrov.lib.response.wrapper.bpp.ResponseWrapperBeanPostProcessor;

/**
 * Задаем автоконфигурацию бина. Часть настройки стартера <p>
 *
 * @author Emil Nasyrov (Emilikan)
 */
@Configuration
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
@RequiredArgsConstructor
@ComponentScan("ru.emilnasyrov.lib.response.wrapper")
public class ResponseWrapperAutoConfiguration {

    private final ApplicationContext applicationContext;

    @Bean
    @ConditionalOnMissingBean
    @DependsOn(value = "responseWrapperBeanPostProcessor")
    public ResponseWrapperAdvice responseWrapperAdvice() {
        return new ResponseWrapperAdvice();
    }

    @Bean
    @ConditionalOnMissingBean
    public ResponseWrapperBeanPostProcessor responseWrapperBeanPostProcessor() {
        return new ResponseWrapperBeanPostProcessor(applicationContext);
    }
}
