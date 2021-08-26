package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {

    public static Random random = new Random();

    public static void startGame() {

        Boss boss = new Boss(2000, 50);
        Warrior warrior = new Warrior(270, 15);
        Medic support = new Medic(230, 5, 20);
        Magic magic = new Magic(260, 20);
        Berserk berserk = new Berserk(280, 10);
        Medic assistant = new Medic(250, 10, 10);
        Hero[] heroes = {warrior, support, magic, berserk, assistant};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void heroesApplySuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].applySuperPower(boss, heroes);
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() -
                        heroes[i].getDamage());
            }
        }
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0)
                heroes[i].setHealth(heroes[i].getHealth()
                        - boss.getDamage());
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        bossHits(boss, heroes);
        heroesHit(boss, heroes);
        heroesApplySuperAbilities(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("___________");
        System.out.println("Boss health: " + boss.getHealth() +
                " [" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName()
                    + " health: " + heroes[i].getHealth() +
                    " [" + heroes[i].getDamage() + "]");
        }
        System.out.println("___________");
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

}
