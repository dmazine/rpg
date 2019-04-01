package br.com.dmazine.rpg.damage;

import br.com.dmazine.rpg.item.Weapon;

public class DefaultDamageCalculationStrategy implements DamageCalculationStrategy {

    @Override
    public int calculateDamage(br.com.dmazine.rpg.character.Character attacker, br.com.dmazine.rpg.character.Character target) {
        return calculateDamage(getAttackPoints(attacker), getWeaponPoints(attacker), getDefensePoints(target));
    }

    private int getAttackPoints(br.com.dmazine.rpg.character.Character character) {
        return character.getStrength() * character.getExperience();
    }

    private int getWeaponPoints(br.com.dmazine.rpg.character.Character character) {
        final Weapon weapon = character.getWeapon();
        return (weapon != null) ? weapon.getDamage() : 0;
    }

    private int getDefensePoints(br.com.dmazine.rpg.character.Character character) {
        return (int) (Math.random() * ((character.getStrength() * character.getExperience()) + 1));
    }

    private int calculateDamage(int attackPoints, int weaponPoints, int defensePoints) {
        final int damage = attackPoints + weaponPoints - defensePoints;
        return (damage > 0 ? damage : 0);
    }

}
