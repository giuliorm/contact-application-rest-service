package ru.juriasan.clientrequestservice.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import ru.juriasan.clientrequestservice.exception.ErrorMessage;

@ControllerAdvice
public class NotFoundControllerAdvice {

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessage requestHandlingNoHandlerFound() {
        return new ErrorMessage("Cannot find handler for request");
    }
}
