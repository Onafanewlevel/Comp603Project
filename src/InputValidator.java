
/**
 * The InputValidator class is responsible for validating user input in a quiz game.
 * It provides methods to check different types of inputs, such as answers, lifeline choices,
 * and readiness signals. The class uses a utility method to validate inputs based on
 * specified valid characters.
 *
 * @author Setefano Muller
 * @author Tharuka Rodrigo
 */
public class InputValidator {

    /**
     * Validates if the user's answer input is a valid answer choice (a, b, c,
     * d, e, or f).
     *
     * @param input The user's input to check.
     * @return true if the input is one of the valid answer choices, false
     * otherwise.
     */
    public boolean checkAnswerInput(String input) {
        return checkInput(input, "abcdef");
    }

    /**
     * Validates if the user's input from a lifeline is a valid answer choice
     * (a, b, c, or d).
     *
     * @param input The user's input to check.
     * @return true if the input is one of the valid lifeline answer choices,
     * false otherwise.
     */
    public boolean checkAnswerFromLifelineInput(String input) {
        return checkInput(input, "abcd");
    }

    /**
     * Validates if the user's input for choosing a lifeline is valid (either
     * '5050' or 'hint').
     *
     * @param input The user's input to check.
     * @return true if the input is '5050' or 'hint', false otherwise.
     */
    public boolean checkLifelineInput(String input) {
        return input.equals("5050") || input.equals("hint");
    }

    /**
     * Validates if the user's input is a readiness signal (either 'y' or 'Y').
     *
     * @param input The user's input to check.
     * @return true if the input is 'y' or 'Y', false otherwise.
     */
    public boolean checkReadyInput(String input) {
        return checkInput(input, "yY");
    }

    /**
     * Utility method that checks if the input consists of a single character
     * and if that character is contained within a set of valid characters.
     *
     * @param input The input string to check.
     * @param validChars A string containing all valid characters.
     * @return true if the input is a single valid character, false otherwise.
     */
    private boolean checkInput(String input, String validChars) {
        return input.length() == 1 && validChars.contains(input);
    }
}
