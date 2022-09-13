package com.mapsTree.account.exception;

public class UserAlreadyExists extends RuntimeException{
    private String message;

    public UserAlreadyExists(String message){
        super(message);
        this.message=message;
    }
    public UserAlreadyExists(){
    }
}
