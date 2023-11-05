package org.example.exceptions;

public class NotEnoughPlayersException extends Exception{
    public NotEnoughPlayersException(String message){
        super(message);
    }
}
