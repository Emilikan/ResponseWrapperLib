package com.example.responsewrapperdemo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.emilnasyrov.lib.response.wrapper.IWrapperService;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Emil Nasyrov (Emilikan)
 */

@SpringBootTest
public class WrapperServiceTest {
    @Autowired
    IWrapperService wrapperService;

    @Test
    public void getDataTest() {
        assertEquals(wrapperService.getData(new Object()), "Additional Information");
    }
}
