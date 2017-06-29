import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

//Application that simulates dice rolling
public class DiceRoller {

    //Method using Math Class
    public static int getMathRandomNumGenerator(int diceMax) {
        int number = (int) (Math.random() * diceMax);
        return number;
    }

    //Method using Random Class
    public static int getRandomNumGenerator(int diceMax) {
        Random randomObject = new Random();
        int number2 = randomObject.nextInt(diceMax);
        return number2;
    }

    public static void main(String[] args) {

        String keepGoing = "y";
        Scanner entry = new Scanner(System.in);

        //Roll 2 n-sided dice
        final int NUM_DICE = 2;
        int[] roll = new int[NUM_DICE];
        int numSides = 0;
        int rollNumber = 1;

        //Greet user
        System.out.println("Welcome to the Grand Circus Casino!");

        //Continue loop while user continues to enter y or Y
        while (keepGoing.equalsIgnoreCase("y")) {

            //Ask user to enter number of sides for a pair of dice
            do {
                System.out.print("How many sides should each die have? ");

                //Retry if entry was not a positive integer
                while (!entry.hasNextInt()) {
                    System.out.println("Must be an integer. Please try again...");
                    System.out.print("How many sides should each die have? ");
                    entry.next();
                }

                numSides = entry.nextInt();

                //Retry if entry was not a positive integer
                if (numSides < 0) {
                    System.out.println("Must be a positive integer. Please try again...");
                }

            } while (numSides < 0);
            //Clear the scanner
            entry.nextLine();

            //Prompt the user to roll the dice
            System.out.print("Press enter to roll the dice...");
            entry.nextLine();

            //Report the roll number
            System.out.println("Roll " + rollNumber);

            //Roll two n-sided dice
            for (int i = 0; i < NUM_DICE; ++i) {

                //To test both option ... switched between Math and Random class based on even / odd roll
                //This is more interesting if more dice were used ... only two dice so testing both
                //if (i % 2 == 0) {
                    roll[i] = getMathRandomNumGenerator(numSides);
                //} else {
                    //roll[i] = getRandomNumGenerator(numSides);
                //}

                System.out.println(roll[i]);
            }

            //Ask the user if he/she wants to roll the dice again
            System.out.print("Would you like to continue? (y/n): ");
            keepGoing = entry.next();
            entry.nextLine();

            rollNumber++;
        }
        System.out.println("Goodbye!");
    }
}
