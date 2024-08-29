
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

    private boolean hasFiftyfity;
    private boolean hasHint;
    private Scanner scan;
    private String input;
    private UserInputHandler userInputHandler;
    private Utils utils;

    public Lifeline() {
        this.hasFiftyfity = true;
        this.hasHint = true;
        this.scan = new Scanner(System.in);
        this.input = null;
        this.userInputHandler = new UserInputHandler();
        this.utils = new Utils();
    }

    public void useLifeline(QuestionLoader question) {
        showRemainingLifelines();

        // Loop until valid lifeline input is received
        while (true) {
            input = scan.nextLine().toLowerCase();

            if (!userInputHandler.checkLifelineInput(input)) {
                System.out.println("Invalid lifeline choice! Please enter '5050' or 'hint'.");
                continue; // Prompt the user again
            }

            // Process the valid lifeline input
            switch (input) {
                case "5050":
                    if (hasFiftyfity) {
                        useFiftyFifty(question);
                        hasFiftyfity = false;
                    } else {
                        System.out.println("You have already used the 50:50 lifeline.");
                    }
                    break;
                case "hint":
                    if (hasHint) {
                        useHint(question);
                        hasHint = false;
                    } else {
                        System.out.println("You have already used the Hint lifeline.");
                    }
                    break;
            }
            break; // Exit the loop after processing the input
        }
        scan.close();
    }

    public void useFiftyFifty(QuestionLoader questionLoader) {
        System.out.println("50:50 Lifeline activated!\n");

        Random random = new Random();
        HashMap<Character, String> options = questionLoader.getOptions();
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
        System.out.println("Hint: " + question.getHint());
    }

    private void showRemainingLifelines() {

        boolean hasAnyLifelines = false;  // Flag to check if there are any lifelines left
        if (!hasAnyLifelines) {
            System.out.println("\nUsing a lifeline...");
            utils.pause(2000);
            System.out.println("\nRemaining Lifelines:");

        } else {
            System.out.println("\nNo remaining lifelines.");
        }

        if (hasFiftyfity) {
            System.out.println("- 50:50 (type '5050')");
            hasAnyLifelines = true;
        }
        if (hasHint) {
            System.out.println("- Hint (type 'hint')");
            hasAnyLifelines = true;
        }
    }

    /**
     * @return the hasFiftyfity
     */
    public boolean isHasFiftyfity() {
        return hasFiftyfity;
    }

    /**
     * @param hasFiftyfity the hasFiftyfity to set
     */
    public void setHasFiftyfity(boolean hasFiftyfity) {
        this.hasFiftyfity = hasFiftyfity;
    }

    /**
     * @return the hasHint
     */
    public boolean isHasHint() {
        return hasHint;
    }

    /**
     * @param hasHint the hasHint to set
     */
    public void setHasHint(boolean hasHint) {
        this.hasHint = hasHint;
    }
}
