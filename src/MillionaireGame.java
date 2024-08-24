
import java.util.Scanner;

/**
 *
 * @author Onafanewlevel
 */
public class MillionaireGame {

    private static boolean answered = false;  // Flag to check if the player has answered
    private static int qCount = 1;  // To track question numbers

    public static void main(String[] args) {
        Messages message = new Messages();
        message.banner();
        Scanner scan = new Scanner(System.in);

        // Get Player name input from user
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

        // Create new questions object
        QuestionLoader questions = new QuestionLoader();

        while (true) {
            answered = false;  // Reset the answered flag for each new question
            showNextQuestion(questions);
            startCountDown(15);  // Start a 15-second countdown

            String userAnswer = getPlayerAnswer();
            answered = true;  // Set answered to true to stop the countdown thread

            pause(2000);  // Optional pause

            if (userAnswer.equals(questions.getAnswer())) {
                System.out.println("\nCorrect!");
                score += 500;
            } else {
                System.out.println("\nIncorrect!");
                message.endMessage(player.getName(), score);
                break;
            }
        }

        scan.close();  // Close the scanner
    }

    private static void showNextQuestion(QuestionLoader questions) {
        pause(2000);
        System.out.println("\n\nQuestion " + qCount + "\n\n");
        pause(2000);

        if (questions.loadNextQuestion()) {
            System.out.println(questions.getQuestion());
            System.out.println("A: " + questions.getA());
            System.out.println("B: " + questions.getB());
            System.out.println("C: " + questions.getC());
            System.out.println("D: " + questions.getD());
            qCount++;  // Increment the question counter
        } else {
            System.out.println("No more questions available.");
        }
    }

    private static String getPlayerAnswer() {
        Scanner scan = new Scanner(System.in);
        String userAnswer;

        while (true) {
            System.out.print("Please enter your answer (a, b, c, or d): ");
            String input = scan.nextLine().trim().toLowerCase();

            if (input.length() == 1 && "abcd".contains(input)) {
                userAnswer = input;
                break;
            } else {
                System.out.println("Enter a valid option dumb dumb!!");
            }
        }

        return userAnswer;
    }

    private static void startCountDown(int seconds) {
        Thread countdownThread = new Thread(() -> {
            for (int i = seconds; i > 0; i--) {
                if (answered) {
                    return;
                }
                System.out.print(i + " ");
                pause(1000);
            }
            if (!answered) {
                System.out.println("Time's up!");
                answered = true;  // Mark as answered to stop user input
            }
        });
        countdownThread.start();  // Start the countdown thread
    }

    private static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // Restore interrupted status
            System.out.println("An error occurred while waiting.");
        }
    }
}
