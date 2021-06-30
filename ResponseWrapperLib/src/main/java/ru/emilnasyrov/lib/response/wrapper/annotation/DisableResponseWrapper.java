package ru.emilnasyrov.lib.response.wrapper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Пометить метод в классе, который помечен {@link EnableResponseWrapper}, для того, чтобы ответ метода не
 * оборачивался в класс-обертку <p>
 *
 * @author Emil Nasyrov (Emilikan)
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DisableResponseWrapper {
}