package br.com.dmazine.rpg.experience;

import java.io.Serializable;

public interface ExperienceGainCalculationStrategy extends Serializable {

    int calculateExperienceGain();

}
