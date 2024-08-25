
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
    private boolean hasAsk;

    public Lifeline() {
        this.hasFiftyfity = true;
        this.hasHint = true;
        this.hasAsk = true;
    }

    public void useLifeline(QuestionLoader question) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().toLowerCase();
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
            case "ask":
                if (hasAsk) {
                    useAskAudience(question);
                    hasAsk = false;
                } else {
                    System.out.println("You have already used the Ask the Audience lifeline.");
                }
                break;
            default:
                System.out.println("Invalid lifeline choice.");
                break;
        }

    }

    public void useFiftyFifty(QuestionLoader questionLoader) {
        System.out.println("50:50 Lifeline activated!");

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
        System.out.println("Remaining options:");
        for (char option : options.keySet()) {
            System.out.println(option + ": " + options.get(option));
        }
    }

    private void useHint(QuestionLoader question) {
        System.out.println("Hint Lifeline activated!");
        System.out.println("Hint: " + question.getHint());
    }

    private void useAskAudience(QuestionLoader question) {
        System.out.println("Ask the Audience Lifeline activated!");
        Random random = new Random();
        // Simulate audience voting
        for (char option : question.getOptions().keySet()) {
            int percentage = random.nextInt(30) + 10;  // Random percentage between 10 and 40
            System.out.println(option + ": " + percentage + "%");
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

    /**
     * @return the hasAsk
     */
    public boolean isHasAsk() {
        return hasAsk;
    }

    /**
     * @param hasAsk the hasAsk to set
     */
    public void setHasAsk(boolean hasAsk) {
        this.hasAsk = hasAsk;
    }

}
