package br.com.dmazine.rpg.character;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CharacterTest {

    @Test
    public void increaseHealth_shouldIncreaseTheHealthAmount() {
        final Character character = new Character("knight", "Knight");

        final int oldAmount = character.getHealth();
        character.increaseHealth(1);

        Assert.assertEquals(oldAmount + 1, character.getHealth());
    }

    @Test
    public void increaseStrength_shouldIncreaseTheStrengthAmount() {
        final Character character = new Character("knight", "Knight");

        final int oldAmount = character.getStrength();
        character.increaseStrength(1);

        Assert.assertEquals(oldAmount + 1, character.getStrength());
    }

    @Test
    public void increaseExperience_shouldIncreaseTheExperienceAmount() {
        final Character character = new Character("knight", "Knight");

        final int oldAmount = character.getExperience();
        character.increaseExperience(1);

        Assert.assertEquals(oldAmount + 1, character.getExperience());
    }

    @Test
    public void healthyCharacter_shouldBeAlive() {
        final Character character = new Character("knight", "Knight");
        character.setHealth(10);

        Assert.assertTrue(character.isAlive());
    }

    @Test
    public void unhealthyCharacter_shouldBeDead() {
        final Character character = new Character("knight", "Knight");
        character.setHealth(0);

        Assert.assertTrue(character.isDead());
    }

    @Test
    public void attackingCharacter_shouldNotIncreaseItsHealth() {
        final Character atacker = new Character("knight", "Knight");

        final Character target = mock(Character.class, Mockito.CALLS_REAL_METHODS);
        atacker.attack(target);

        final ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(target).decreaseHealth(argumentCaptor.capture());

        Assert.assertTrue(argumentCaptor.getValue() >= 0);
    }

}