package com.example.responsewrapperdemo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Emil Nasyrov (Emilikan)
 */

public class WrapperModelTests {

    @Test
    public void setDataTest() {
        final String someInfo = "someInfo";

        Wrapper wrapper = new Wrapper();
        wrapper.setData(someInfo);

        assertEquals(wrapper.getSomeInfo(), someInfo);
    }

    @Test
    public void setBodyTest() {
        final MainModel body = new MainModel("name", "surname");

        Wrapper wrapper = new Wrapper();
        wrapper.setBody(body);

        assertEquals(wrapper.getMain(), body);
    }
}
