package br.com.dmazine.rpg.exception;

public class SaveGameException extends GameException {

    public SaveGameException(String message) {
        super(message);
    }

    public SaveGameException(String message, Throwable cause) {
        super(message, cause);
    }

}