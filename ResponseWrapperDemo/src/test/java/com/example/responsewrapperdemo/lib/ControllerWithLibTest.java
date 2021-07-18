package com.example.responsewrapperdemo.lib;

import com.example.responsewrapperdemo.lib.context.ControllerTestConfiguration;
import com.example.responsewrapperdemo.model.MainModel;
import com.example.responsewrapperdemo.model.Wrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Emil Nasyrov (Emilikan)
 */

@AutoConfigureMockMvc
@SpringBootTest(classes = ControllerTestConfiguration.class)
public class ControllerWithLibTest {
    private final String BASE_ENDPOINT = "/test";

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test() throws Exception {
        final Wrapper wrapper = new Wrapper(new MainModel("Name", "Surname"), "Additional Information");
        final String result = objectMapper.writeValueAsString(wrapper);

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
        final Wrapper wrapper1 = new Wrapper(new MainModel("Name1", "Surname1"), "Additional Information");
        final Wrapper wrapper2 = new Wrapper(new MainModel("Name2", "Surname2"), "Additional Information");

        final List<Wrapper> wrapperList = List.of(wrapper1, wrapper2);
        final String result = objectMapper.writeValueAsString(wrapperList);

        mvc.perform(
                get(BASE_ENDPOINT + "/collection")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(result)));
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
