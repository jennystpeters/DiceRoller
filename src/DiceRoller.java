import java.util.Scanner;
import java.lang.Math;

//Application that simulates dice rolling
public class DiceRoller {

    public static int randomNumGenerator(int diceMax) {

        int number = (int)(Math.random() * diceMax);

        return number;
    }

    public static void main(String[] args) {

        char keepGoing = 'y';
        Scanner entry = new Scanner(System.in);

        //"Roll" two n-sided dice
        final int NUM_DICE = 2;
        int[] roll = new int[NUM_DICE];

        int numSides = 0;
        int rollNumber = 1;

        System.out.println("Welcome to the Grand Circus Casino!");

        while ((keepGoing == 'y') || (keepGoing == 'Y')) {

            //Ask the user to enter the number of sides for a pair of dice
            System.out.print("How many sides should each die have? ");
            numSides = entry.nextInt();

            //Prompt the user to roll the dice
            System.out.println("Roll " + rollNumber);

            //"Roll" two n-sided dice, display the results of each
            for(int i = 0; i < NUM_DICE; ++i) {
                roll[i] = randomNumGenerator(numSides);
                System.out.println(roll[i]);
            }

            //Ask the user if he/she wants to roll the dice again
            System.out.print("Would you like to continue? (y/n): ");
            keepGoing = entry.next().charAt(0);

            rollNumber++;
        }
        System.out.println("Bye for now!");
    }
}
