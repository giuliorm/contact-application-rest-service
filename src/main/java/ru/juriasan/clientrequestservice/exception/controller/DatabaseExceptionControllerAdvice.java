package ru.juriasan.clientrequestservice.exception.controller;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.juriasan.clientrequestservice.exception.DBEntityNotFoundException;
import ru.juriasan.clientrequestservice.exception.ErrorMessage;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@ControllerAdvice
public class DatabaseExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler({SQLException.class, DataAccessException.class})
    public ErrorMessage handleDatabaseException(HttpServletRequest req, Exception ex) {
        return new ErrorMessage(
                String.format("Request %s caused database exception %s",
                        req.getRequestURL(), ex.getMessage()));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler({ DBEntityNotFoundException.class })
    public ErrorMessage dbEntityNotFound(HttpServletRequest req, Exception ex) {
        return new ErrorMessage(
                String.format(
                        "DB entity has not been found on request %s: %s",
                        req.getRequestURL(), ex.getMessage()));
    }
}
