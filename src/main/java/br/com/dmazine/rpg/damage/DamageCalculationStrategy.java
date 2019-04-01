package br.com.dmazine.rpg.damage;

import br.com.dmazine.rpg.character.Character;
import br.com.dmazine.rpg.weapon.Weapon;

import java.io.Serializable;

public interface DamageCalculationStrategy extends Serializable {

    int calculateDamage(Character attacker, Character target, Weapon weapon);

}
