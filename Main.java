import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Arena arena = new Arena();
        int turn = 1;

        Scanner scan = new Scanner (System.in);


        while (!Arena.isGameEnded) {

            System.out.println("Turn: " + turn);

            System.out.println("Computer's units:");
            printUnits(Arena.computerUnits);

            System.out.println("Player's units:");
            printUnits(Arena.playerUnits);

            System.out.print("Which unit you choose: ");

            int player_choice = scan.nextInt();

            player_choice = player_choice -1;

            System.out.println("\nYou choose " + Arena.playerUnits.get(player_choice).getInfo());

            int computer_choice = new Random().nextInt(Arena.computerUnits.size());

            while (Arena.computerUnits.get(computer_choice).isDead) {

                computer_choice = new Random().nextInt(Arena.computerUnits.size());

            }

            System.out.println("Computer chooses " + Arena.computerUnits.get(computer_choice).getInfo());

            System.out.println();

            arena.battle(player_choice, computer_choice);

            turn = turn + 1;
        }

        scan.close();

    }

    private static void printUnits(ArrayList<Unit> units) {

        for (int i = 0; i < units.size(); i++) {
        
            System.out.println((i + 1) + ". " + units.get(i).getInfo());
        
        }
    }
}