package br.com.dmazine.rpg.repository;

import br.com.dmazine.rpg.Game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileGameRepository implements GameRepository {

    private final String basePath;

    public FileGameRepository(String basePath) {
        this.basePath = basePath;
    }

    @Override
    public void saveGame(String name, Game game) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(buildFilePath(name)))) {
            outputStream.writeObject(game);
        } catch (Exception e) {
            throw new RepositoryException(String.format("Error saving game %s", name), e);
        }
    }

    @Override
    public Game loadGame(String name) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(buildFilePath(name)))) {
            return (Game) inputStream.readObject();
        } catch (Exception e) {
            throw new RepositoryException(String.format("Game %s could not be loaded", name), e);
        }
    }

    private String buildFilePath(String fileName) {
        return String.format("%s%s", basePath, fileName);
    }

}
