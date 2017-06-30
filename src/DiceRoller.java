import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

//Author: Jenny St. Peters
//June 29, 2017
//Lab 5 - Dice Roller App

//Application that simulates dice rolling
public class DiceRoller {

    //Method using Math Class
    public static int getMathRandomNumGenerator(int diceMax) {
        //Fix to remove zero - ceiling
        int number = (int) Math.ceil(Math.random() * diceMax) ;
        return number;
    }

    //Method using Random Class
    public static int getRandomNumGenerator(int diceMax) {
        Random randomObject = new Random();
        //Random is zero to number exclusive - add 1 to get to diceMax
        int number2 = randomObject.nextInt(diceMax + 1);
        return number2;
    }

    //Output special messages for Snake Eyes and Midnight (or Boxcars)
    private static String craps(int[] crapsRoll) {
        String specialMessage = null;
        if ((crapsRoll[0] == 1) && (crapsRoll[1] == 1)) {
            specialMessage = "Snake Eyes!";
        }
        if ((crapsRoll[0] == 6) && (crapsRoll[1] == 6)) {
            specialMessage = "Midnight!";
        }
        return specialMessage;
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

                //Retry if entry was not an integer
                while (!entry.hasNextInt()) {
                    System.out.println("Must be an integer greater than 1. Please try again...");
                    System.out.print("How many sides should each die have? ");
                    entry.next();
                }

                numSides = entry.nextInt();

                //Retry if entry was not a positive integer greater than 1 (can't flip if only "1-sided")
                if (numSides <= 1) {
                    System.out.println("Must be a positive integer greater than 1. Please try again...");
                }

            } while (numSides <= 1);
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

            if(craps(roll) != null) {
                System.out.println(craps(roll));
            }

            //Ask the user if he/she wants to roll the dice again
            System.out.print("Would you like to continue? (y/n): ");
            keepGoing = entry.next();
            entry.nextLine();

            rollNumber++;
        }
        System.out.print("Goodbye!");
    }
}
