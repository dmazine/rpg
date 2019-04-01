package br.com.dmazine.rpg.command.game;

import br.com.dmazine.rpg.Game;

public class SelectWeaponCommand extends AbstractGameCommand {

    private String weaponId;

    public SelectWeaponCommand(Game game, String weaponId) {
        super(game);
        this.weaponId = weaponId;
    }

    @Override
    public void execute() {
        getGame().getPlayer().selectWeapon(weaponId);
    }
}
