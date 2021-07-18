package com.example.responsewrapperdemo.web;

import com.example.responsewrapperdemo.model.MainModel;
import com.example.responsewrapperdemo.model.Wrapper2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.emilnasyrov.lib.response.wrapper.annotation.DisableResponseWrapper;
import ru.emilnasyrov.lib.response.wrapper.annotation.EnableResponseWrapper;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Emil Nasyrov (Emilikan)
 */

@EnableResponseWrapper(wrapperClass = Wrapper2.class)
@RequestMapping("/test2")
public class Controller2 {

    @GetMapping
    public MainModel test() {
        return new MainModel("Name", "Surname");
    }

    @GetMapping("/collection")
    public Collection<MainModel> testList() {
        Collection<MainModel> mainModels = new ArrayList<>();
        mainModels.add(new MainModel("Name1", "Surname1"));
        mainModels.add(new MainModel("Name2", "Surname2"));

        return mainModels;
    }

    @DisableResponseWrapper
    @GetMapping("/unwrapped")
    public MainModel unwrapped() {
        return new MainModel("Name", "Surname");
    }

}
