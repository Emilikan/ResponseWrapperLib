package ru.emilnasyrov.lib.response.wrapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;

/**
 * @author Emil Nasyrov (Emilikan)
 */

@Getter
@AllArgsConstructor
public class MethodInformation {
    @NonNull
    private final MethodParameter returnType;
    @NonNull
    private final MediaType selectedContentType;
    @NonNull
    private final Class<?> selectedConverterType;
    @NonNull
    private final ServerHttpRequest request;
    @NonNull
    private final ServerHttpResponse response;
}
