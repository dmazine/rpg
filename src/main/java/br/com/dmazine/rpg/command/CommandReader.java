package br.com.dmazine.rpg.command;

@FunctionalInterface
public interface CommandReader {

    Command readCommand();

}
