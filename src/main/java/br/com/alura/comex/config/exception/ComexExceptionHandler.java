package br.com.alura.comex.config.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ComexExceptionHandler {

    private final MessageSource messageSource;

    public ComexExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<List<ValidationExceptionDto>> handleValidation(MethodArgumentNotValidException ex, WebRequest request) {
        List<ValidationExceptionDto> errorList = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach( fieldError -> {
            ValidationExceptionDto dto = new ValidationExceptionDto(
                    fieldError.getField(),
                    messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()));
            errorList.add(dto);
        });

        return new ResponseEntity<>(errorList, HttpStatus.BAD_REQUEST);
    }

}
