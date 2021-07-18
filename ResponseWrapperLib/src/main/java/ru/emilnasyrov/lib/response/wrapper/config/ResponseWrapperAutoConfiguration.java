package ru.emilnasyrov.lib.response.wrapper.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.emilnasyrov.lib.response.wrapper.IWrapperService;
import ru.emilnasyrov.lib.response.wrapper.advice.ResponseWrapperAdvice;

import java.util.List;

/**
 * Задаем автоконфигурацию бина. Часть настройки стартера <p>
 *
 * @author Emil Nasyrov (Emilikan)
 */
@Configuration
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
@AllArgsConstructor
public class ResponseWrapperAutoConfiguration {
    private final List<IWrapperService<?, ?>> wrapperServiceList;

    @Bean
    @ConditionalOnMissingBean
    public ResponseWrapperAdvice responseWrapperAdvice() {
        return new ResponseWrapperAdvice(wrapperServiceList);
    }
}
