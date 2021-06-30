package com.example.responsewrapperdemo.service;

import org.springframework.stereotype.Service;
import ru.emilnasyrov.lib.response.wrapper.IWrapperService;

/**
 * Сервис, отдающий дополнительные данные, которыми наполнится модель-обертка <p>
 *
 * @author Emil Nasyrov (Emilikan)
 */

@Service
public class WrapperServiceImpl implements IWrapperService {
    @Override
    public Object getData(Object body) {
        return "Additional Information";
    }
}
