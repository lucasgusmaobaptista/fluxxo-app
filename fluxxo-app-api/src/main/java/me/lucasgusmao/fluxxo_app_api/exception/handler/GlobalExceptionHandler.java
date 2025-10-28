package me.lucasgusmao.fluxxo_app_api.exception.handler;

import me.lucasgusmao.fluxxo_app_api.exception.response.ErrorField;
import me.lucasgusmao.fluxxo_app_api.exception.response.ErrorResponse;
import me.lucasgusmao.fluxxo_app_api.exception.custom.AlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleAlreadyExists(AlreadyExistsException e) {
        return ErrorResponse.conflict(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> errorFields = e.getFieldErrors();
        List<ErrorField> errors = errorFields
                .stream()
                .map(error -> new ErrorField(error.getField(), error.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Erro de validação", errors);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleErrosNaoTratados(RuntimeException e) {
        e.printStackTrace();
        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ops! Ocorreu um erro Inesperado!", List.of());
    }

}
