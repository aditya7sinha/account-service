package com.mapsTree.account.exception;

public class UserNotFoundException extends RuntimeException{
    private String message;

    public UserNotFoundException(String message){
        this.message = message;
    }

    public UserNotFoundException(){
    }

}
