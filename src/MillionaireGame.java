
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The MillionaireGame class is the main entry point for the quiz game. It
 * handles the setup, manages the main game loop, and writes the results to an
 * output file after each game. The class facilitates user interaction and
 * initializes all necessary components like Player, GameLogic, and Lifeline.
 *
 * @author Setefano Muller
 * @author Tharuka Rodrigo
 */
public class MillionaireGame {

    public static void main(String[] args) {
        Messages message = new Messages();
        message.banner(); // Display the game banner
        Scanner scan = new Scanner(System.in); // Scanner for reading user input
        int contestantNumber = 1; // Tracks the contestant number for each game session

        boolean playAgain = true; // Controls the game loop

        while (playAgain) {
            // Prompt for contestant's name and create a new player
            System.out.print("Please enter your name, contestant number " + contestantNumber + ": ");
            String playerName = scan.nextLine().toUpperCase();
            Player player = new Player(playerName); // Initialize a new player
            QuestionFileReader questions = new QuestionFileReader(); // Initialize the question loader
            Lifeline lifeline = new Lifeline(); // Initialize lifelines

            // Initialize and start the game engine
            GameLogic game = new GameLogic(player, questions, lifeline);
            game.startGame(); // Start the game session

            // Write the results to an output file
            writeResultsToFile(player, contestantNumber);

            // Prompt user to start a new game or exit
            System.out.print("Would you like to start a new game? (yes/no): ");
            String response = scan.nextLine().trim().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false; // End the game loop if the user does not want to play again
                System.out.println("Thank you for playing! Goodbye!");
            } else {
                contestantNumber++; // Increment the contestant number for the next game session
            }
        }

        scan.close(); // Close the scanner
    }

    /**
     * Writes the results of the game to an output file.
     *
     * @param player The player whose results will be written to the file.
     * @param contestantNumber The contestant number.
     */
    public static void writeResultsToFile(Player player, int contestantNumber) {
        try (FileWriter fileWriter = new FileWriter("src/resources/game_results.txt", true); PrintWriter printWriter = new PrintWriter(fileWriter)) {

            // Write player details and results to the file
            printWriter.println("Contestant Number: " + contestantNumber);
            printWriter.println("Player: " + player.getName());
            printWriter.println("Score: " + player.getScore());
            printWriter.println("Has Lifeline Remaining: " + player.isHasLifeline());
            printWriter.println("-----");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file."); // Handle file writing errors
            e.printStackTrace();
        }
    }
}
