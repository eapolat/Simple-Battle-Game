import java.util.ArrayList;

public class Rogue extends Unit{

    
    public Rogue(String name, int health, int level) {
        super(name, health, level);

        maxHealth = level;
        attack = level + 2;
    }

    public int getAttack() {

        return attack;

    }

    public int getMaxHealth() {

        return maxHealth;

    }

    public void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {        

        attack = getAttack();

        arenaOpponent.damage(attack);

        System.out.println(name + " damaged arena opponent by " + attack + ".");


    }

    public void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {

        attack = getAttack();

        arenaOpponent.damage(attack);

        System.out.println(name + " damaged arena opponent by " + attack + ".");

    }

    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {

        attack = getAttack();

        RandomUnit(enemyWaiting).damage(attack);

        System.out.println(name + " damaged waiting opponent by " + attack + ".");

    }
    
}
