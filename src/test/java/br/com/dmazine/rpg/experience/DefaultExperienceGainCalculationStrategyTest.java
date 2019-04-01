package br.com.dmazine.rpg.experience;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultExperienceGainCalculationStrategyTest {

    @Test
    public void experienceGain_shouldBeBetweenMinAndMaxValues() {
        final int min = 1;
        final int max = 5;

        final ExperienceGainCalculationStrategy experienceGainCalculationStrategy = new DefaultExperienceGainCalculationStrategy(min, max);
        final int experienceGain = experienceGainCalculationStrategy.calculateExperienceGain();

        Assert.assertTrue(experienceGain >= min);
        Assert.assertTrue(experienceGain <= max);
    }

}