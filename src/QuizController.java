
/**
 * The QuizController class manages the display and progression of questions in the quiz game.
 * It tracks the current question number and displays the next question along with available options
 * and lifelines. The class also interacts with the Player, Lifeline, and QuestionFileReader classes
 * to provide a seamless question flow in the game.
 *
 * @author Setefano Muller
 * @author Tharuka Rodrigo
 */
public class QuizController {

    private int qCount = 1;  // To track the current question number

    /**
     * Displays the next question to the player, including answer options and
     * the option to use a lifeline or walk away. It retrieves the next question
     * from the QuestionFileReader and updates the question counter.
     *
     * @param questions The QuestionFileReader object to load and display
     * questions.
     * @param lifeline The Lifeline object to manage lifeline usage.
     * @param player The Player object representing the current player.
     */
    public void showNextQuestion(QuestionFileReader questions, Lifeline lifeline, Player player) {
        TimeUtil.pause(2000); // Pause before displaying the next question
        int money = PrizeLevel.getAmountByQuestionLevel(qCount); // Get prize amount for the current question level
        System.out.println("\n\nQuestion " + (qCount) + "\n"); // Display the question number
        System.out.print(player.getName() + ", for $" + money + ": ");
        TimeUtil.pause(2000); // Pause for dramatic effect

        if (questions.loadNextQuestion()) { // Load the next question from the file
            // Display the question and answer options
            System.out.println(questions.getQuestion());
            System.out.println(questions.getA());
            System.out.println(questions.getB());
            System.out.println(questions.getC());
            System.out.println(questions.getD());
            System.out.println("");

            // Display lifeline option if the player has any lifelines left
            if (player.isHasLifeline()) {
                System.out.println("e) Use Lifeline");
            }
            System.out.println("f) Walk Away!"); // Option to quit the game
            qCount++;  // Increment the question counter for the next round
        } else {
            System.out.println("No more questions available."); // Notify if no more questions are left
        }
    }

    /**
     * Gets the current question count. This method returns the number of
     * questions that have been asked so far, adjusted by -1 to reflect the
     * index position.
     *
     * @return The number of questions that have been asked.
     */
    public int getQCount() {
        return this.qCount - 1;
    }
}
