import java.util.Random;
import java.util.Scanner;

public class Project1 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static int highScore = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println("\n\nWelcome to the Number Guessing Game!");
        boolean playAgain = true;

        while (playAgain) {
            playGame();
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");
        }

        System.out.println("\nThanks for playing! 🎉");
    }

    static void playGame() {
        int min = 1;
        int max = 100;
        int maxAttempts = selectDifficulty();

        int targetNumber = random.nextInt(max - min + 1) + min;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("\nI have picked a number between " + min + " and " + max + ".");
        System.out.println("You have " + maxAttempts + " attempts to guess it.\n");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = getValidInteger();

            attempts++;

            if (guess == targetNumber) {
                guessedCorrectly = true;
                System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");

                if (attempts < highScore) {
                    highScore = attempts;
                    System.out.println("🏆 New High Score: " + highScore + " attempts!");
                } else {
                    System.out.println("Your current high score: " + highScore + " attempts.");
                }

                break;
            } else if (guess < targetNumber) {
                System.out.println("📉 Too low! Try again.");
            } else {
                System.out.println("📈 Too high! Try again.");
            }
        }

        if (!guessedCorrectly) {
            System.out.println("❌ You've used all attempts! The number was: " + targetNumber);
        }
    }

    static int selectDifficulty() {
        System.out.println("\nChoose a difficulty level:");
        System.out.println("1. Easy (30 attempts)");
        System.out.println("2. Medium (20 attempts)");
        System.out.println("3. Hard (10 attempts)");

        int choice;
        while (true) {
            System.out.print("\nEnter 1, 2, or 3: ");
            choice = getValidInteger();

            if (choice == 1) return 30;
            else if (choice == 2) return 20;
            else if (choice == 3) return 10;
            else System.out.println("Invalid choice. Please try again.");
        }
    }

    static int getValidInteger() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next(); // discard invalid input
        }
        return scanner.nextInt();
    }
}
