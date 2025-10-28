package me.lucasgusmao.fluxxo_app_api.exception.handler;

import jakarta.servlet.http.HttpServletRequest;
import me.lucasgusmao.fluxxo_app_api.exception.response.ResponseError;
import me.lucasgusmao.fluxxo_app_api.exception.custom.AlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseError handleAlreadyExists(AlreadyExistsException e) {
        return ResponseError.conflict(HttpStatus.CONFLICT.value(), e.getMessage(), List.of());
    }

    // You can add other handlers (validation, not found, generic) here as needed.
}

