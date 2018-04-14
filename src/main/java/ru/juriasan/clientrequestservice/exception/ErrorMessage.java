package ru.juriasan.clientrequestservice.exception;

public class ErrorMessage {

    private String errorMessage;

    public ErrorMessage(String message) {
        this.errorMessage = message;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String message) {
        this.errorMessage = message;
    }
}
