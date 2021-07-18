package com.example.responsewrapperdemo.service;

import com.example.responsewrapperdemo.model.MainModel;
import com.example.responsewrapperdemo.model.Passport;
import com.example.responsewrapperdemo.model.Wrapper2;
import lombok.NonNull;
import ru.emilnasyrov.lib.response.wrapper.IWrapperService;
import ru.emilnasyrov.lib.response.wrapper.annotation.WrapperService;

/**
 * @author Emil Nasyrov (Emilikan)
 */

@WrapperService(wrapperModel = Wrapper2.class)
public class Wrapper2ServiceImpl implements IWrapperService<MainModel, Passport> {

    @Override
    public Passport getData(@NonNull MainModel body) {
        return new Passport("series", "number");
    }

}
