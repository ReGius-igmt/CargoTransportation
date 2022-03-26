package ru.regiuss.cargotransportation.server.utils;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.regiuss.cargotransportation.server.exception.CustomException;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseInfo handleRuntimeException(CustomException e){
        return new ResponseInfo(false, e.getInfo());
    }
}
