import java.util.ArrayList;

public class Warrior extends Unit {
    
    public Warrior(String name, int health, int level) {

        super(name, health, level);

        attack = level + 1;
        maxHealth = level + 2;

    }

    public int getAttack() {

        return attack;

    }

    public int getMaxHealth() {

        return maxHealth;

    }

    public void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {        

        System.out.println(name + " does nothing.");

    }

    public void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {

        attack = getAttack();

        arenaOpponent.damage(attack);

        System.out.println(name + " damaged arena opponent by " + attack + ".");

    }

    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {

        attack = getAttack();

        arenaOpponent.damage(attack);

        System.out.println(name + " damaged arena opponent by " + attack + ".");

    }

}
