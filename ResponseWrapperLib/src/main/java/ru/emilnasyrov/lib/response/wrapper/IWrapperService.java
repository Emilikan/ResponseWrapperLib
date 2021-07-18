package ru.emilnasyrov.lib.response.wrapper;

import lombok.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

/**
 * @author Emil Nasyrov (Emilikan)
 */

@Service
public interface IWrapperService<Body, Data> {
    /**
     * Получаем дополнительную информацию для ее установки в объекте {@link IWrapperModel}
     * В проекте необходимо реализовать сервис, которые будет реализовывать метод getData, по запросу на который
     * будет отдаваться объект дополнительных данных (который затем необходимо распарсить в классе реализации
     * {@link IWrapperModel} в методе {@link IWrapperModel#setData(Object, MethodInformation)})
     * <p>
     * <br/><br/>
     *
     * @param body придет тело, которое возвращает оригинальный метод, для которого создается обертка
     * @return вернуть дополнительную информацию для ее установки в объекте {@link IWrapperModel}
     */
    @Nullable
    Data getData(@NonNull Body body);

    default <BodyHelper> Data getDataHelper (@NonNull BodyHelper body) {
        @SuppressWarnings("unchecked")
        Body body1 = (Body) body;

        return getData(body1);
    }
}
