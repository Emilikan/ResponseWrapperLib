package com.example.responsewrapperdemo.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.emilnasyrov.lib.response.wrapper.IWrapperModel;
import ru.emilnasyrov.lib.response.wrapper.MethodInformation;

/**
 * @author Emil Nasyrov (Emilikan)
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wrapper2 implements IWrapperModel<MainModel, Passport> {
    @JsonUnwrapped
    MainModel main;

    Passport passport;

    @Override
    public void setData(Passport passport, @NonNull MethodInformation methodInformation) {
        this.passport = passport;
    }

    @Override
    public void setBody(@NonNull MainModel body, @NonNull MethodInformation methodInformation) {
        this.main = body;
    }
}
