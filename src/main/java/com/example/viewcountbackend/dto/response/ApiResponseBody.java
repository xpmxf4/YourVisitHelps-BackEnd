package com.example.viewcountbackend.dto.response;

import lombok.*;
import org.springframework.http.*;

@Getter
public class ApiResponseBody<T> {

    private final int code;
    private final HttpStatus status;
    private final T data;
    private final String message;

    @Builder
    private ApiResponseBody(HttpStatus status, String message, T data) {
        this.code = status.value();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponseBody<T> of(HttpStatus httpStatus, String message, T data) {
        return new ApiResponseBody<>(httpStatus, message, data);
    }

    public static <T> ApiResponseBody<T> ok(T data) {
        return of(HttpStatus.OK, HttpStatus.OK.name(), data);
    }

    public static <T> ApiResponseBody<T> badRequest(String message) {
        return of(HttpStatus.BAD_REQUEST, message, null);
    }
}
