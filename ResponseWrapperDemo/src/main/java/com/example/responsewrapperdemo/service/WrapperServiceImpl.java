package com.example.responsewrapperdemo.service;

import com.example.responsewrapperdemo.model.MainModel;
import com.example.responsewrapperdemo.model.Wrapper;
import lombok.NonNull;
import ru.emilnasyrov.lib.response.wrapper.IWrapperService;
import ru.emilnasyrov.lib.response.wrapper.annotation.WrapperService;

/**
 * Сервис, отдающий дополнительные данные, которыми наполнится модель-обертка <p>
 *
 * @author Emil Nasyrov (Emilikan)
 */

@WrapperService(wrapperModel = Wrapper.class)
public class WrapperServiceImpl implements IWrapperService<MainModel, String> {

    @Override
    public String getData(@NonNull MainModel body) {
        return "Additional Information";
    }

}
