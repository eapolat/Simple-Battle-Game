import java.util.ArrayList;

public class Necromancer extends Unit {
    
    public Necromancer(String name, int health, int level) {
        super(name, health, level);
        
        maxHealth = level + 1;

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

        if (RandomUnit(allyWaiting) != null) {

            Unit chosen_one = RandomUnit(allyWaiting);

            chosen_one.revive();

            System.out.println(chosen_one.name + " revived by " + name);

        } else {
        
            damage(1);

            System.out.println(name + " damages self by 1.");

        }
  

    }

    public void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting) {

        if (arenaOpponent.level > 1) {

            arenaOpponent.level -= 1;

            System.out.println(arenaOpponent.name + " levels down by 1.");

        }

    }
    

}
