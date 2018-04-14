package ru.juriasan.clientrequestservice.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.juriasan.clientrequestservice.exception.ErrorMessage;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class BadRequestControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorMessage handleIllegalArgumentException(HttpServletRequest req, Exception ex) {
        return new ErrorMessage(
                String.format("Illegal arguments for request %s: %s",
                        req.getRequestURL(), ex.getMessage()));
    }
}
