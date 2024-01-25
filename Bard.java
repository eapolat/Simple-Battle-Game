import java.util.ArrayList;

public class Bard extends Unit {
    
    public Bard(String name, int health, int level) {
        super(name, health, level);

        maxHealth = level;
        attack = level;
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

        heal(1);

        System.out.println(name + " healed self by " + 1 + ".");
    }

    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {

        Unit chosen_one = RandomUnit(allyWaiting);

        chosen_one.level = level + 1;

        System.out.println( chosen_one.name +" levels up by" + name);

    }
    

}
