
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Onafanewlevel
 */
public class Lifeline {

    private boolean hasFiftyfifty;
    private boolean hasHint;
    private Scanner scan;
    private String input;
    private UserInputHandler userInputHandler;
    private Utils utils;

    public Lifeline() {
        this.hasFiftyfifty = true;
        this.hasHint = true;
        this.scan = new Scanner(System.in);
        this.input = null;
        this.userInputHandler = new UserInputHandler();
        this.utils = new Utils();
    }

    public void chooseLifeline(QuestionLoader question, Player player) {
        showRemainingLifelines(player);

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
                    // Should never reach here if input is validated properly
                    break;
            }
        }

        // Update player lifeline status
        if (!hasFiftyfifty && !hasHint) {
            player.setHasLifeline(false);
        }
    }

    public void useFiftyFifty(QuestionLoader questionLoader) {
        System.out.println("50:50 Lifeline activated!\n");

        Random random = new Random();
        HashMap<Character, String> options = questionLoader.getOptions();
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

    private void useHint(QuestionLoader question) {
        System.out.println("Hint Lifeline activated!\n");
        System.out.println(question.getHint());
    }

    private void showRemainingLifelines(Player player) {

        if (player.isHasLifeline()) {
            System.out.println("\nUsing a lifeline...");
            utils.pause(2000);
            System.out.println("\nRemaining Lifelines:");
            if (hasFiftyfifty) {
                System.out.println("- 50:50 (type '5050')");
            }
            if (hasHint) {
                System.out.println("- Hint (type 'hint')");
            }

        } else {
            System.out.println("\nNo remainig lifelines.");
        }
    }
}
