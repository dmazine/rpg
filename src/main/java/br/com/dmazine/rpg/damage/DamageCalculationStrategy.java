package br.com.dmazine.rpg.damage;

import java.io.Serializable;

public interface DamageCalculationStrategy extends Serializable {

    int calculateDamage(br.com.dmazine.rpg.character.Character attacker, br.com.dmazine.rpg.character.Character target);

}
