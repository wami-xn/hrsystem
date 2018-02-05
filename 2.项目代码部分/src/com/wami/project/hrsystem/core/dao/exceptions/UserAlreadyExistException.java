package com.wami.project.hrsystem.core.dao.exceptions;

public class UserAlreadyExistException extends AbstractException {
    public UserAlreadyExistException(String msg){
        super(msg);
    }
}
