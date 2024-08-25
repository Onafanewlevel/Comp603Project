/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Onafanewlevel
 */
import java.util.Scanner;

public class UserInputHandler {

    private Scanner scanner;

    public UserInputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public String getPlayerAnswer() {
        String userAnswer;

        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.length() == 1 && "abcdef".contains(input)) {
                userAnswer = input;
                break;
            } else {
                System.out.println("Enter a valid option dumb dumb!!");
            }
        }

        return userAnswer;
    }

    public boolean isPlayerReady() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().trim();  // Get new input from user
            // Check if input length is 1 and it matches 'y' or 'Y'
            if (input.length() == 1 && "yY".contains(input)) {
                return true;  // Player is ready
            } else {
                System.out.println("Enter y when ready...");
            }
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
