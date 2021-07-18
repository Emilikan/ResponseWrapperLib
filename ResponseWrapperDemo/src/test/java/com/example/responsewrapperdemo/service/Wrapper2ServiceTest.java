package com.example.responsewrapperdemo.service;

import com.example.responsewrapperdemo.service.context.ControllerTestConfiguration;
import com.example.responsewrapperdemo.model.MainModel;
import com.example.responsewrapperdemo.model.Passport;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Emil Nasyrov (Emilikan)
 */

@SpringBootTest(classes = ControllerTestConfiguration.class)
public class Wrapper2ServiceTest {
    @Autowired
    Wrapper2ServiceImpl wrapperService;

    @Test
    public void getDataTest() {
        assertEquals(wrapperService.getData(new MainModel("name", "surname")), new Passport("series", "number"));
    }
}
