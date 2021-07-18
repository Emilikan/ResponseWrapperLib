package ru.emilnasyrov.lib.response.wrapper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ru.emilnasyrov.lib.response.wrapper.bpp.ResponseWrapperBeanPostProcessor;

/**
 * Аннотация для инжекта мапы сервисов-оберток в поле класса или в метод
 * Аннотацию реализует {@link ResponseWrapperBeanPostProcessor} <p/>
 *
 * @author Emil Nasyrov (Emilikan)
 */

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectWrapperServiceMap {
}
