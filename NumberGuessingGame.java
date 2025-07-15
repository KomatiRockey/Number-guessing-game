
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int round = 1;
        final int MAX_ATTEMPTS = 7;
        boolean playAgain = true;

        System.out.println("🎮 Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n🔁 Round " + round + ": Guess the number between 1 and 100!");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Attempt " + (attempts + 1) + "/" + MAX_ATTEMPTS + " - Your guess: ");
                int guess;

                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }

                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low! 📉");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! 📈");
                } else {
                    System.out.println("🎉 Correct! You guessed it in " + attempts + " attempts.");
                    score++;
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The correct number was " + numberToGuess);
            }

            System.out.println("✅ Your current score: " + score);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();
            playAgain = response.equals("yes");
            round++;
        }

        System.out.println("👋 Thanks for playing! Final score: " + score);
        scanner.close();
    }
}
