import java.util.ArrayList;

public class Healer extends Unit{

    public Healer(String name, int health, int level) {
        super(name, health, level);

        maxHealth = level + 2;
        attack = level;
    }

    public int getAttack() {

        return attack;

    }

    public int getMaxHealth() {

        return maxHealth;

    }

    public void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {        

        if (health == maxHealth) {

            RandomUnit(allyWaiting).heal(level);

            System.out.println(name + " healed ally waiting by " + level + ".");

        } else {

            heal(1);

            System.out.println(name + " healed self by " + 1 + ".");

        }

    }

    public void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {

        attack = getAttack();

        RandomUnit(enemyWaiting).damage(attack);

        System.out.println(name + " damaged waiting opponent by " + attack + ".");

    }

    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {

        if (RandomUnit(allyWaiting) != null) {

            RandomUnit(enemyWaiting).revive();

            System.out.println(name + " revived waiting enemy.");

        }

        System.out.println(name + "does nothing because there is no there is no dead unit.");

    }
    
}
