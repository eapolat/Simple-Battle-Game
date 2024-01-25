import java.util.ArrayList;
import java.util.Random;

public class Arena {
    
    static ArrayList<Unit> playerUnits;
    static ArrayList<Unit> computerUnits;
    static boolean isGameEnded;
    static boolean isTurnEnded;

    public Arena() {
        playerUnits = new ArrayList<>();
        computerUnits = new ArrayList<>();
        isGameEnded = false;
        isTurnEnded = false;

        createUnits(playerUnits);
        createUnits(computerUnits);
    }

    private void createUnits(ArrayList<Unit> units) {

        Random random = new Random();

        int num_of_Warriors = 0;
        int maxUnits = 7;

        while (units.size() < maxUnits) {

            String[] unit_names = {"Warrior", "Archer", "Healer", "Rogue", "Wizard", "Bard", "Necromancer"};
            String random_name = unit_names[random.nextInt(unit_names.length)];

            Unit unit = null;

            if (random_name == "Warrior") {

                unit = new Warrior("Warrior", 3,1 );
                num_of_Warriors++;
            
            } else if (random_name == "Archer") {

                unit = new Archer("Archer", 2, 1);

            } else if (random_name == "Healer") {
                    
                unit = new Healer("Healer", 3, 1);

            } else if (random_name == "Rogue") {

                unit = new Rogue("Rogue", 1, 1);

            } else if (random_name == "Wizard") {

                unit = new Wizard("Wizard", 3, 1);

            } else if (random_name == "Bard") {

                unit = new Bard("Bard",1 ,1);

            } else if (random_name =="Necromancer") {

                unit = new Necromancer("Necromancer", 2, 1);
                    
            }
                        
            if (unit != null) {

                units.add(unit);

            }

            if (num_of_Warriors == 0 && units.size() == maxUnits - 1) {

                units.add(new Warrior("Warrior", 1, 1));
            
            }
    
        }
    
    }

    public void battle(int playerIndex, int computerIndex) {

        isTurnEnded = false;

        while(!isTurnEnded) {
        
            Unit playerUnit = playerUnits.get(playerIndex);
        
            Unit computerUnit = computerUnits.get(computerIndex);

        
            playerUnit.firstPhase(computerUnit, playerUnits, computerUnits);
            computerUnit.firstPhase(playerUnit, computerUnits, playerUnits);

            checkTheDead(playerUnit, computerUnit);

            if (isTurnEnded) {

                System.out.println("Battle ended at phase 1.");

                return;

            }

            playerUnit.secondPhase(computerUnit, playerUnits, computerUnits);
            computerUnit.secondPhase(playerUnit, computerUnits, playerUnits);

            checkTheDead(playerUnit, computerUnit);

            if (isTurnEnded) {

                System.out.println("Battle ended at phase 2.");

                return;

            }

            playerUnit.thirdPhase(computerUnit, playerUnits, computerUnits);
            computerUnit.thirdPhase(playerUnit, computerUnits, playerUnits);

            checkTheDead(playerUnit, computerUnit);

            if (isTurnEnded) {

                System.out.println("Battle ended at phase 3.");

                return;

            }

            playerUnits.add(playerUnit);
            computerUnits.add(computerUnit);

            if (playerUnit.isDead && !computerUnit.isDead) {

                computerUnit.increaseLevel();

                System.out.println(computerUnit + " levels up.");
        
            } else if (!playerUnit.isDead && computerUnit.isDead) {
        
                playerUnit.increaseLevel();

                System.out.println(playerUnit + " levels up.");

        
                // } else if (!playerUnit.isDead && !computerUnit.isDead) {
        
                //    playerUnit.increaseLevel();
            }

            checkGameEnded();
    
        }

    }

    private void checkTheDead(Unit unit1, Unit unit2) {

        if (unit1.isDead) {

            isTurnEnded = true;

            System.out.println(unit1 + " is dead now.");

        } else if (unit2.isDead) {

            isTurnEnded = true;

            System.out.println(unit2 + " is dead now.");

        }
    }

    public static void checkGameEnded() {

        isGameEnded = true;

        for (int i = 0; i < computerUnits.size(); i++) {
            
            if (computerUnits.get(i).health > 0) {

                isGameEnded = false;
    
            }

        }

        if (isGameEnded == true) {

            return;

        }

        isGameEnded = true;

        for (int j = 0; j < playerUnits.size(); j++) {
        
            if (playerUnits.get(j).health > 0) {

                isGameEnded = false;
    
            }

        }
    }


    public static boolean isGameEnded() {

        checkGameEnded();

        return isGameEnded;
    }
}

