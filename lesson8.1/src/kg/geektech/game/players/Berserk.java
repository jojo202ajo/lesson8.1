package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Berserk extends Hero {
    public Berserk(int health, int damage) {
        super(health, damage,
                SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
    int cofsentforberserk = RPG_Game.random.nextInt(5)+ 2;
        boss.setHealth(boss.getHealth() -  boss.getDamage() / cofsentforberserk);
        System.out.println("berserk возврашает урон "+boss.getDamage()/ cofsentforberserk );
    }
}
