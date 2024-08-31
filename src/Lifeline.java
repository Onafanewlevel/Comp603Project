
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * The Lifeline class manages the lifeline functionalities in a quiz game. It
 * provides methods to activate different lifelines, such as "50:50" and "Hint",
 * and handles user inputs related to these lifelines. The class ensures that
 * lifelines are only used if available and provides feedback to the player
 * about remaining lifelines.
 *
 * @author Setefano Muller
 * @author Tharuka Rodrigo
 */
public class Lifeline {

    private boolean hasFiftyfifty; // Indicates if the player has the 50:50 lifeline available
    private boolean hasHint; // Indicates if the player has the Hint lifeline available
    private Scanner scan; // Scanner to read user input
    private String input; // Stores user input
    private InputValidator userInputHandler; // Validates user inputs
    private TimeUtil utils; // Utility for pausing the game

    /**
     * Constructor to initialize the Lifeline class with all lifelines
     * available.
     */
    public Lifeline() {
        this.hasFiftyfifty = true;
        this.hasHint = true;
        this.scan = new Scanner(System.in);
        this.input = null;
        this.userInputHandler = new InputValidator();
        this.utils = new TimeUtil();
    }

    /**
     * Allows the player to choose a lifeline and activates the chosen lifeline
     * if available. Updates the player's lifeline status and ensures that each
     * lifeline can only be used once.
     *
     * @param question The QuestionFileReader object to access current question
     * details.
     * @param player The Player object to manage lifeline usage.
     */
    public void chooseLifeline(QuestionFileReader question, Player player) {
        showRemainingLifelines(player); // Display available lifelines

        boolean validChoiceMade = false;

        while (!validChoiceMade) {
            input = scan.nextLine().toLowerCase();

            if (!userInputHandler.checkLifelineInput(input)) {
                System.out.println("Invalid lifeline choice! Please enter '5050' or 'hint'.");
                continue; // Prompt the user again
            }

            // Process the valid lifeline input
            switch (input) {
                case "5050":
                    if (hasFiftyfifty) {
                        useFiftyFifty(question);
                        hasFiftyfifty = false;
                        validChoiceMade = true; // A valid lifeline choice was made
                    } else {
                        System.out.println("You have already used the 50:50 lifeline.");
                    }
                    break;
                case "hint":
                    if (hasHint) {
                        useHint(question);
                        hasHint = false;
                        validChoiceMade = true; // A valid lifeline choice was made
                    } else {
                        System.out.println("You have already used the Hint lifeline.");
                    }
                    break;
                default:
                    // This case should never be reached due to input validation
                    break;
            }
        }

        // Update player lifeline status
        if (!hasFiftyfifty && !hasHint) {
            player.setHasLifeline(false); // All lifelines used
        }
    }

    /**
     * Activates the 50:50 lifeline by removing two incorrect answers from the
     * current question.
     *
     * @param questionLoader The QuestionFileReader object to access current
     * question options.
     */
    public void useFiftyFifty(QuestionFileReader questionLoader) {
        System.out.println("50:50 Lifeline activated!\n");

        Random random = new Random();
        HashMap<Character, String> options = questionLoader.getOptions(); // Get all options
        if (options == null || options.isEmpty()) {
            System.out.println("No options available to remove.");
            return;
        }

        char correctAnswer = questionLoader.getAnswer().charAt(0);
        int removed = 0;

        while (removed < 2) {
            char option = (char) ('a' + random.nextInt(4)); // Randomly select an option 'a', 'b', 'c', or 'd'
            if (option != correctAnswer && options.containsKey(option)) {
                System.out.println("Removing option: " + option);
                options.remove(option);
                removed++;
            }
        }

        // Display remaining options
        System.out.println("\nRemaining options:");
        for (char option : options.keySet()) {
            System.out.println(options.get(option));
        }
    }

    /**
     * Activates the Hint lifeline by displaying a hint for the current
     * question.
     *
     * @param question The QuestionFileReader object to access current question
     * hint.
     */
    private void useHint(QuestionFileReader question) {
        System.out.println("Hint Lifeline activated!\n");
        System.out.println(question.getHint());
    }

    /**
     * Displays the remaining lifelines available to the player.
     *
     * @param player The Player object to check if any lifelines are still
     * available.
     */
    private void showRemainingLifelines(Player player) {
        if (player.isHasLifeline()) {
            System.out.println("\nUsing a lifeline...");
            utils.pause(2000); // Pause for dramatic effect
            System.out.println("\nRemaining Lifelines:");
            if (hasFiftyfifty) {
                System.out.println("- 50:50 (type '5050')");
            }
            if (hasHint) {
                System.out.println("- Hint (type 'hint')");
            }
        } else {
            System.out.println("\nNo remaining lifelines.");
        }
    }
}
