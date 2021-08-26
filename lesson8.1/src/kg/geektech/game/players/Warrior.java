package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int coeff = RPG_Game.random.nextInt(5) + 2;
        boss.setHealth(boss.getHealth()
                - this.getDamage() * coeff);
        System.out.println("Critical damage: "
                + this.getDamage() * coeff);
    }
}
