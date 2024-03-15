package com.example;

// imports scanner and random module.
import java.util.Random;
import java.util.Scanner;

/**
 * Dice guessing game.
 *
 * @author Spencer S.
 * @version 1.0
 * @since 2024-Mar-15
 */
public final class DiceGame {
  /** Stops random instantiation from happening. */
  private DiceGame() {
    // Prevents instantiation.
  }

  /**
   * Main Code base.
   *
   * @param args Command line arguments (not used).
   */
  public static void main(final String[] args) {
    // Scanner and random number setup
    final Scanner in = new Scanner(System.in);
    final Random rand = new Random();

    // counter variable for while loop
    int counter = 0;

    // used to fix magic number issue
    final int numberSix = 6;

    // guessing counter variable
    int guessAmount = 0;

    // random number generator from 1-6
    final int randomNumber = rand.nextInt(6) + 1;

    // opening statement
    System.out.println("This program roll's a dice and");
    System.out.print("you have to guess the correct number!");

    // while loop that contains all the code
    // checks if counter is 0 or needs to end loop
    while (counter == 0) {
      // input statement
      System.out.println("Enter your a guess number: ");

      // casts as string first
      final String guessString = in.nextLine();

      // try catch for invalid (strings/non whole/less or above 1-6)
      try {
        // casts as int from string
        final Integer guessInteger = Integer.parseInt(guessString);
        if (guessInteger > numberSix || guessInteger < 1) {
          System.out.println("Input must range from 1-6!");
          break;
        } else {
          // if statement with answer key
          // correct statement
          if (guessInteger == randomNumber) {
            guessAmount = guessAmount + 1;
            System.out.println("Correct number! You used");
            System.out.print(guessAmount + " guess(es)!");
            // ends loop
            counter = counter + 1;

            // else if statement for greater
          } else if (guessInteger > randomNumber) {
            System.out.println("Inputted guess is too high!");
            guessAmount = guessAmount + 1;

            // else if statement for less
          } else if (guessInteger < randomNumber) {
            System.out.println("Inputted guess is too low!");
            guessAmount = guessAmount + 1;

            // unused/debugging statement
          } else {
            System.out.println("Bug statement,");
            System.out.print("should never be used.");
          }
        }

        // catch statement for bad inputs
      } catch (NumberFormatException error) {
        System.out.println("Value must be a whole number between 1-6");

        // breaks while loop, stops program.
        break;
      }
    }
    // closes scanner
    in.close();
  }
}
