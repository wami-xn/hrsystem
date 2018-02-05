package com.wami.project.hrsystem.core.dao.exceptions;

public class AbstractException extends RuntimeException {

    private static final String MESSAGE = "异常信息缺失";

    public AbstractException(String msg) {
        super(msg);
    }
    public AbstractException() {
        this(MESSAGE);
    }

}
