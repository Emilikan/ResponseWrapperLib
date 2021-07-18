package ru.emilnasyrov.lib.response.wrapper.annotation;

import org.springframework.stereotype.Service;
import ru.emilnasyrov.lib.response.wrapper.IWrapperModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ru.emilnasyrov.lib.response.wrapper.IWrapperService;

/**
 * Аннотация заменяет собой {@link Service}.<p>
 *
 * Использовать аннотацию для использования различных реализаций сервисов {@link IWrapperService} для каждой из оберток.
 * Повесить над сервисом, реализующим {@link IWrapperService} <p>
 *
 * Принимает в качестве аргумента класс-обертку, для которого используется сервис <p>
 *
 * @author Emil Nasyrov (Emilikan)
 */
@Service
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface WrapperService {
    Class<? extends IWrapperModel<?, ?>> wrapperModel();
}
