package br.com.dmazine.rpg.damage;

import br.com.dmazine.rpg.character.Character;
import br.com.dmazine.rpg.weapon.Weapon;

public class DefaultDamageCalculationStrategy implements DamageCalculationStrategy {

    @Override
    public int calculateDamage(Character attacker, Character target, Weapon weapon) {
        return calculateDamage(getAttackPoints(attacker), getWeaponPoints(weapon), getDefensePoints(target));
    }

    private int getAttackPoints(Character character) {
        return character.getStrength() * character.getExperience();
    }

    private int getWeaponPoints(Weapon weapon) {
        if (weapon == null) {
            return 0;
        }

        return weapon.getDamage();
    }

    private int getDefensePoints(Character character) {
        return (int) (Math.random() * ((character.getStrength() * character.getExperience()) + 1));
    }

    private int calculateDamage(int attackPoints, int weaponPoints, int defensePoints) {
        final int damage = attackPoints + weaponPoints - defensePoints;
        return (damage > 0 ? damage : 0);
    }

}
