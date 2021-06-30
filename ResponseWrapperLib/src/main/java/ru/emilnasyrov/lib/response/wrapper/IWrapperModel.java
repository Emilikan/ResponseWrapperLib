package ru.emilnasyrov.lib.response.wrapper;

/**
 * @author Emil Nasyrov (Emilikan)
 */

public interface IWrapperModel {
    /**
     * Установка дополнительной информации (реализовать метод таким образом, чтобы заполнить ваш класс-обертку)
     *
     * @param object дополнительная информация
     */
    void setData(Object object);

    /**
     * Установка тела запроса (реализация должна содержать поле типа Object, в который будет помещен оригинальный ответ)
     *
     * @param object тело запроса
     */
    void setBody(Object object);
}
