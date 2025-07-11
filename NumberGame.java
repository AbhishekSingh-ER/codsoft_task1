import java.util.*;

public class NumberGame {
    public static void main(String[] args) {
        System.out.println("***** Welcome To Random Number Guessing Game *****");
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int limit = 5; // maximum attempts per round
        int totalRounds = 0;
        int win = 0;

        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nNew Game Started! Guess the number between 1 to 100.");

            while (attempts < limit) {
                System.out.print("Enter your guess: ");
                int guess;

                // Input validation using try-catch
                try {
                    guess = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    sc.nextLine(); // Clear the invalid input from scanner buffer
                    continue; // Skip this iteration and ask again
                }

                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed it right.");
                    win++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                System.out.println("Attempts left: " + (limit - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("You lost! The number was: " + randomNumber);
            }

            totalRounds++;

            System.out.print("Do you want to play again? (y/n): ");
            char choice = sc.next().charAt(0);
            sc.nextLine(); // Consume the newline character
            if (choice != 'y' && choice != 'Y') {
                playAgain = false;
            }
        }

        System.out.println("\nTotal Rounds Played: " + totalRounds);
        System.out.println("Total Wins: " + win);
        System.out.println("Your Score: " + win + "/" + totalRounds);

        sc.close();
    }
}
