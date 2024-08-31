
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MillionaireGame {

    public static void main(String[] args) {
        Messages message = new Messages();
        message.banner();
        Scanner scan = new Scanner(System.in);
        int contestantNumber = 1;

        boolean playAgain = true;

        while (playAgain) {
            System.out.print("Please enter your name, contestant number " + contestantNumber + ": ");
            String playerName = scan.nextLine().toUpperCase();
            Player player = new Player(playerName);
            QuestionLoader questions = new QuestionLoader();
            Lifeline lifeline = new Lifeline();

            // Initialize the game engine
            GameLogic game = new GameLogic(player, questions, lifeline);
            game.startGame();  // Start the game

            // Write the results to an output file
            writeResultsToFile(player, contestantNumber);

            System.out.print("Would you like to start a new game? (yes/no): ");
            String response = scan.nextLine().trim().toLowerCase();

            if (!response.equals("yes")) {
                playAgain = false;
                System.out.println("Thank you for playing! Goodbye!");
            } else {
                // Increment the contestant number for the next game
                contestantNumber++;
            }
        }

        scan.close();
    }

    /**
     * Writes the results of the game to an output file.
     *
     * @param player The player whose results will be written to the file.
     * @param contestantNumber The contestant number.
     */
    public static void writeResultsToFile(Player player, int contestantNumber) {
        try (FileWriter fileWriter = new FileWriter("src/resources/game_results.txt", true); PrintWriter printWriter = new PrintWriter(fileWriter)) {

            printWriter.println("Contestant Number: " + contestantNumber);
            printWriter.println("Player: " + player.getName());
            printWriter.println("Score: " + player.getScore());
            printWriter.println("Has Lifeline Remaining: " + player.isHasLifeline());
            printWriter.println("-----");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
