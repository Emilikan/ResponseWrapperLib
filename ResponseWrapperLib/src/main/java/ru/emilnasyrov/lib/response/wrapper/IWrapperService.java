package ru.emilnasyrov.lib.response.wrapper;

import org.springframework.stereotype.Service;

/**
 * @author Emil Nasyrov (Emilikan)
 */

@Service
public interface IWrapperService {
    /**
     * Получаем дополнительную информацию для ее установки в объекте {@link IWrapperModel}
     * В проекте необходимо реализовать сервис, которые будет реализовывать метод getData, по запросу на который
     * будет отдаваться объект дополнительных данных (который затем необходимо распарсить в классе реализации
     * {@link IWrapperModel} в методе {@link IWrapperModel#setData(Object)})
     * <p>
     * <br/><br/>
     *
     * @param body придет тело, которое возвращает оригинальный метод, для которого создается обертка
     * @return вернуть дополнительную информацию для ее установки в объекте {@link IWrapperModel}
     */
    Object getData(Object body);
}
