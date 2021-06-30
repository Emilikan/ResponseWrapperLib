package ru.emilnasyrov.lib.response.wrapper.annotation;

import org.springframework.web.bind.annotation.RestController;
import ru.emilnasyrov.lib.response.wrapper.IWrapperModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация заменяет собой {@link RestController}.
 * <br/> <br/>
 * Пометить класс-контроллер для того, чтобы ответы всех его rest методов, отдающих Object
 * были обернуты в класс-обертку (В случае если отдается Collection - будут обернуты все элементы коллекции)
 * на уровне DispatcherServlet <br/>
 * Используется для оборачивания всех ответов методов в класс-обертку <p>
 * <p>
 * Для того, чтобы какой-то конкретный метод не обрабатывался, необходимо аннотировать его {@link DisableResponseWrapper} <p>
 * <p>
 * Сами значения полей находит с помощью методов репозитория, реализующего интерфейс {@link ru.emilnasyrov.lib.response.wrapper.IWrapperService} <p>
 *
 * @author Emil Nasyrov (Emilikan)
 */
@RestController
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableResponseWrapper {
    Class<? extends IWrapperModel> wrapperClass();
}
