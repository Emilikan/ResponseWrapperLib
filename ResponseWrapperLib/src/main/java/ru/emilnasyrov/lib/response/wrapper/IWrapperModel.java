package ru.emilnasyrov.lib.response.wrapper;

import lombok.NonNull;
import org.springframework.lang.Nullable;

/**
 * @author Emil Nasyrov (Emilikan)
 */

public interface IWrapperModel<Body, Data> {
    /**
     * Установка дополнительной информации (реализовать метод таким образом, чтобы заполнить ваш класс-обертку)
     *
     * @param data дополнительная информация
     */
    void setData(@Nullable Data data, @NonNull MethodInformation methodInformation);

    default <DataHelper> void setDataHelper(@Nullable DataHelper data, @NonNull MethodInformation methodInformation){
        @SuppressWarnings("unchecked")
        Data data1 = (Data) data;

        setData(data1, methodInformation);
    }


    /**
     * Установка тела запроса (реализация должна содержать поле типа Object, в который будет помещен оригинальный ответ)
     *
     * @param body тело запроса
     */
    void setBody(@NonNull Body body, @NonNull MethodInformation methodInformation);

    default <BodyHelper> void setBodyHelper(@NonNull BodyHelper body, @NonNull MethodInformation methodInformation) {
        @SuppressWarnings("unchecked")
        Body body1 = (Body) body;

        setBody(body1, methodInformation);
    }
}
