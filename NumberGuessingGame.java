import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    static int score = 0;
    static int highestScore = 0;

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=================================");
            System.out.println("        NUMBER GUESS GAME");
            System.out.println("=================================");
            System.out.println("1. Easy Mode");
            System.out.println("2. Medium Mode");
            System.out.println("3. Hard Mode");
            System.out.println("4. Check Current Score");
            System.out.println("5. Check Highest Score");
            System.out.println("6. Clear Score");
            System.out.println("7. Game Details");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    playGame(7, 1, "EASY");
                    break;
                case 2:
                    playGame(5, 2, "MEDIUM");
                    break;
                case 3:
                    playGame(3, 3, "HARD");
                    break;
                case 4:
                    System.out.println("\nCurrent Score: " + score);
                    break;
                case 5:
                    System.out.println("\nHighest Score: " + highestScore);
                    break;
                case 6:
                    score = 0;
                    System.out.println("\nScore cleared successfully");
                    break;
                case 7:
                    showDetails();
                    break;
                case 8:
                    System.out.println("\nThanks for playing");
                    System.exit(0);
                default:
                    System.out.println("\nInvalid option");
            }
        }
    }

    static void playGame(int attempts, int reward, String levelName) {

        int secretNumber = random.nextInt(101);
        boolean won = false;

        System.out.println("\n---------------------------------");
        System.out.println("DIFFICULTY: " + levelName);
        System.out.println("Guess a number between 0 and 100");
        System.out.println("Attempts: " + attempts);
        System.out.println("Win +" + reward + " | Lose -" + reward);
        System.out.println("---------------------------------");

        for (int i = 1; i <= attempts; i++) {
            System.out.print("Guess " + i + ": ");
            int guess = sc.nextInt();

            if (guess == secretNumber) {
                won = true;
                System.out.println("Correct! You won the round");
                score += reward;
                if (score > highestScore) highestScore = score;
                break;
            } else if (guess > secretNumber) {
                System.out.println("Too high");
            } else {
                System.out.println("Too low");
            }
        }

        if (!won) {
            System.out.println("You lost. Number was: " + secretNumber);
            score -= reward;
            if (score < 0) score = 0;
        }

        System.out.println("Current Score: " + score);
    }

    static void showDetails() {
        System.out.println("\n-------------- DETAILS ------------");
        System.out.println("Easy Mode:   7 attempts | +1 / -1");
        System.out.println("Medium Mode: 5 attempts | +2 / -2");
        System.out.println("Hard Mode:   3 attempts | +3 / -3");
        System.out.println("Guess range: 0–100");
        System.out.println("Highest score is tracked");
        System.out.println("-----------------------------------");
    }
}
