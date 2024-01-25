import java.util.ArrayList;
import java.util.Random;

public abstract class Unit {

    String name;
    int health;
    int level;
    boolean isDead;
    int maxHealth;
    int attack;

    public abstract int getAttack();

    public abstract int getMaxHealth();

    public abstract void firstPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting);

    public abstract void secondPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting);

    public abstract void thirdPhase(Unit arenaOpponent, ArrayList<Unit> allyWaiting, ArrayList<Unit> enemyWaiting);


    public Unit(String name, int health, int level) {

        this.name = name;
        this.health = health;
        this.level = level;
        this.isDead = false;

    }

    public int getLevel() {

        return level;
    }


    public void damage(int damageAmount) {

        health = health - damageAmount;
        
        if (health <= 0) {

            isDead = true;
            health = 0;
        
        }
    
    }

    public void increaseLevel() {

        level++;

        attack = attack + 1;
        maxHealth = maxHealth + 1;

    }

    public void decreaseLevel() {

        if (level > 1) {

            level =  level - 1;
        }
            
        if (health > maxHealth) {
            
            health = maxHealth;
        
        }
        
    }

    public void revive() {

        if (isDead) {

            isDead = false;
            decreaseLevel();
            health = maxHealth;

        }

    }

    public void heal(int healAmount) {

        health = health + healAmount;

        if (health > maxHealth) {
            health = maxHealth;
        }

    }

    public static Unit RandomUnit(ArrayList<Unit> units) {

        ArrayList<Unit> availableUnits = new ArrayList<>();

        for (Unit unit : units) {

            if (!unit.isDead) {

                availableUnits.add(unit);
            
            }
        }

        if (!availableUnits.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(availableUnits.size());
            return availableUnits.get(randomIndex);
        }

        return null;
    }


    public String getInfo() {

        return name + ", LVL: " + level + ", ATK: " + attack + ", HEALTH: " + health + "/" + maxHealth;
    
    }

}
