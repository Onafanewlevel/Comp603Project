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

    public boolean checkAnswerInput(String input) {
        return checkInput(input, "abcdef");
    }
    
    public boolean checkAnswerFromLifelineInput(String input) {
        return checkInput(input, "abcd");
    }

    public boolean checkLifelineInput(String input) {
        return input.equals("5050") || input.equals("hint");
    }

    public boolean checkReadyInput(String input) {
        return checkInput(input, "yY");
    }

    private boolean checkInput(String input, String validChars) {
        return input.length() == 1 && validChars.contains(input);
    }
}
