package com.wami.project.hrsystem.core.enties.functional;

public class ErrorMessageEntity {
    public ErrorMessageEntity() {
    }

    public ErrorMessageEntity(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;

    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private String errorMessage;
}
