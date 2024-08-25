
import java.util.Scanner;

public class MillionaireGame {

    private static boolean answered = false;  // Flag to check if the player has answered

    public static void main(String[] args) {
        Messages message = new Messages();
        message.banner();

        // Get Player name input from user
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter your name contestant!: ");
        String playerName = scan.nextLine();

        // Display welcome message and prompt user to start game
        message.welcome(playerName);
        message.startBanner();
        char ready = scan.next().charAt(0);
        while (ready != 'y') {
            message.startBanner();
            ready = scan.next().charAt(0);
        }
        message.startBanner2();

        // Create new player object
        Player player = new Player(playerName);
        int score = player.getScore();

        // Create necessary objects for refactored classes
        Lifeline lifeline = new Lifeline();
        QuestionLoader questions = new QuestionLoader();
        UserInputHandler userInputHandler = new UserInputHandler();
        CountdownTimer countdownTimer = new CountdownTimer(answered);
        QuestionManager questionManager = new QuestionManager();

        while (true) {
            answered = false;  // Reset the answered flag for each new question
            questionManager.showNextQuestion(questions, lifeline);
            countdownTimer.startCountDown(15);  // Start a 15-second countdown

            String userAnswer = userInputHandler.getPlayerAnswer();
            answered = true;  // Set answered to true to stop the countdown thread
            countdownTimer.setAnswered(true);  // Update countdown timer state

            Utils.pause(2000);  // Optional pause

            if (userAnswer.equals(questions.getAnswer())) {
                System.out.println("\nCorrect!");
                score += 500;
            } else if (userAnswer.equals("e")) {
                System.out.println("Use lifeline");
            } else if(userAnswer.equals("f")){
                System.out.println("Quit");
                message.endMessage(player.getName(), score);
            }else {
                System.out.println("\nIncorrect!");
                message.endMessage(player.getName(), score);
                break;
            }
        }

        userInputHandler.closeScanner();  // Close the scanner
        scan.close();  // Close the main scanner
    }
}
