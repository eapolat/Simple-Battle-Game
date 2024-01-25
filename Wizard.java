import java.util.ArrayList;

public class Wizard extends Unit {

    public Wizard(String name, int health, int level) {
        super(name, health, level);

        maxHealth = level + 2;
        attack = 1;
    }

    public int getAttack() {

        return attack;

    }

    public int getMaxHealth() {

        return maxHealth;

    }

    public void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {        

        System.out.println(name + "does nothing.");

    }

    public void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {

        System.out.println(name + "does nothing.");


    }

    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {

        attack = getAttack();

        for (Unit unit : enemyWaiting) {

            unit.damage(attack);

        }
    }
    
    
}
