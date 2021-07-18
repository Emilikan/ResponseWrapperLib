package com.example.responsewrapperdemo.web;

import com.example.responsewrapperdemo.model.MainModel;
import com.example.responsewrapperdemo.web.context.ControllerTestConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Emil Nasyrov (Emilikan)
 */

@WebMvcTest(controllers = Controller.class)
@ContextConfiguration(classes = ControllerTestConfiguration.class)
public class Controller2Test {
    private final String BASE_ENDPOINT = "/test2";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test() throws Exception {
        final String result = objectMapper.writeValueAsString(new MainModel("Name", "Surname"));

        mvc.perform(
                get(BASE_ENDPOINT)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(result)));
    }

    @Test
    public void testList() throws Exception {
        final Collection<MainModel> mainModels = new ArrayList<>();
        mainModels.add(new MainModel("Name1", "Surname1"));
        mainModels.add(new MainModel("Name2", "Surname2"));

        final String result = objectMapper.writeValueAsString(mainModels);

        mvc.perform(
                get(BASE_ENDPOINT + "/collection")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(status().isOk()).andExpect(content().string(equalTo(result)));
    }

    @Test
    public void unwrappedTest() throws Exception {
        final String result = objectMapper.writeValueAsString(new MainModel("Name", "Surname"));

        mvc.perform(
                get(BASE_ENDPOINT + "/unwrapped")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(result)));
    }
}
