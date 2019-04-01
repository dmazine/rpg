package br.com.dmazine.rpg.exception;

public class LoadGameException extends GameException {

    public LoadGameException(String message) {
        super(message);
    }

    public LoadGameException(String message, Throwable cause) {
        super(message, cause);
    }

}