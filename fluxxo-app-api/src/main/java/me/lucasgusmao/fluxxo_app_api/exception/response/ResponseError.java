package me.lucasgusmao.fluxxo_app_api.exception.response;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ResponseError(int status, String message, List<ErrorField> errors ) {

    public static ResponseError defaultResponse(String message) {
        return new ResponseError(HttpStatus.BAD_REQUEST.value(), message, List.of());
    }

    public static ResponseError conflict(int status, String message, List<ErrorField> errors) {
        return new ResponseError(HttpStatus.CONFLICT.value(), message, List.of());
    }
}

