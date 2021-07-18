package com.example.responsewrapperdemo.service;

import com.example.responsewrapperdemo.model.MainModel;
import com.example.responsewrapperdemo.model.Wrapper;
import lombok.NonNull;
import ru.emilnasyrov.lib.response.wrapper.IWrapperService;
import ru.emilnasyrov.lib.response.wrapper.annotation.WrapperService;

import javax.annotation.PostConstruct;

/**
 * Сервис, отдающий дополнительные данные, которыми наполнится модель-обертка <p>
 *
 * @author Emil Nasyrov (Emilikan)
 */

@WrapperService(wrapperModel = Wrapper.class)
public class WrapperServiceImpl implements IWrapperService<MainModel, String> {

    @PostConstruct
    public void init() {
        System.out.println("3");
    }

    @Override
    public String getData(@NonNull MainModel body) {
        return "Additional Information";
    }

}
