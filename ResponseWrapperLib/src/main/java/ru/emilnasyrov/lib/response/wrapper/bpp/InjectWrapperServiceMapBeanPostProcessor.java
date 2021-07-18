package ru.emilnasyrov.lib.response.wrapper.bpp;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import ru.emilnasyrov.lib.response.wrapper.IWrapperModel;
import ru.emilnasyrov.lib.response.wrapper.IWrapperService;
import ru.emilnasyrov.lib.response.wrapper.annotation.InjectWrapperServiceMap;
import ru.emilnasyrov.lib.response.wrapper.annotation.WrapperService;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Архитектурный компонент, отвечающий за внедрения зависимостей через аннотацию {@link InjectWrapperServiceMap}
 * Внедрение возможно только в переменную типа {@code Map<Class<? extends IWrapperModel<?, ?>>, IWrapperService<?, ?>>} <p/>
 *
 * Внедрение возможно посредствам инжекта в поле класса или вызова метода с передачей в него необходимого аргумента <p/>
 *
 * @author Emil Nasyrov (Emilikan)
 */

@Component
@AllArgsConstructor
public class InjectWrapperServiceMapBeanPostProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        setFieldInjects(bean);
        setMethodInject(bean);
        return bean;
    }

    @SneakyThrows
    private void setMethodInject(Object bean) {
        Set<Method> methods = Arrays.stream(bean.getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(InjectWrapperServiceMap.class))
                .collect(Collectors.toSet());

        for (Method method : methods) {
            method.invoke(bean, getWrapperServiceMap());
        }

    }

    @SneakyThrows
    private void setFieldInjects(Object bean) {
        Set<Field> fields = Arrays.stream(bean.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(InjectWrapperServiceMap.class))
                .collect(Collectors.toSet());

        for (Field field : fields) {
            field.setAccessible(true);
            field.set(bean, getWrapperServiceMap());
        }

    }

    private Map<Class<? extends IWrapperModel<?, ?>>, IWrapperService> getWrapperServiceMap() {
        Map<String, IWrapperService> beansOfType = applicationContext.getBeansOfType(IWrapperService.class);

        return beansOfType.values().stream()
                .collect(Collectors.toMap(
                        (t) -> {
                            if (!t.getClass().isAnnotationPresent(WrapperService.class)) {
                                throw new RuntimeException("Не все сервисы, реализующие IWrapperService, аннотированы @WrapperService");
                            }
                            return t.getClass().getAnnotation(WrapperService.class).wrapperModel();
                        },
                        (t) -> t
                        )
                );
    }

}
