package com.example.responsewrapperdemo.lib;

import com.example.responsewrapperdemo.lib.context.ControllerTestConfiguration;
import com.example.responsewrapperdemo.model.Wrapper;
import com.example.responsewrapperdemo.model.Wrapper2;
import com.example.responsewrapperdemo.service.Wrapper2ServiceImpl;
import com.example.responsewrapperdemo.service.WrapperServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.emilnasyrov.lib.response.wrapper.IWrapperModel;
import ru.emilnasyrov.lib.response.wrapper.IWrapperService;
import ru.emilnasyrov.lib.response.wrapper.annotation.InjectWrapperServiceMap;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Emil Nasyrov (Emilikan)
 */

@SpringBootTest(classes = ControllerTestConfiguration.class)
public class InjectToFieldWrapperServiceMapTest {

    @InjectWrapperServiceMap
    private Map<Class<? extends IWrapperModel<?, ?>>, IWrapperService<?, ?>> wrapperServiceMap;

    @Test
    public void injectToFieldTest(){
        assertTrue(wrapperServiceMap.containsKey(Wrapper.class));
        assertTrue(wrapperServiceMap.containsKey(Wrapper2.class));

        assertEquals(wrapperServiceMap.get(Wrapper.class).getClass(), WrapperServiceImpl.class);
        assertEquals(wrapperServiceMap.get(Wrapper2.class).getClass(), Wrapper2ServiceImpl.class);
    }
}
