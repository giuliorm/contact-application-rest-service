package ru.juriasan.clientrequestservice.exception;

public class DBEntityNotFoundException extends RuntimeException {

    public DBEntityNotFoundException(String message) {
        super(message);
    }
}
