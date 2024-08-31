
import java.util.Scanner;

/**
 * The GameLogic class implements the core logic for the quiz game. It manages
 * the game flow, including starting the game, handling user inputs, presenting
 * questions, managing lifelines, and determining when the game ends. The class
 * utilizes other components like Player, Messages, QuestionFileReader,
 * InputValidator, CountdownTimer, QuizController, and Lifeline to execute
 * different parts of the game logic.
 *
 * @author Setefano Muller
 * @author Tharuka Rodrigo
 */
public class GameLogic implements GameControl {

    private final Player player; // The current player of the game
    private final Messages message = new Messages(); // Handles game messages
    private final QuestionFileReader questions; // Loads and manages questions
    private final InputValidator inputValidator = new InputValidator(); // Validates user inputs
    private final CountdownTimer countdownTimer; // Manages the countdown timer for answering questions
    private final QuizController questionManager = new QuizController(); // Manages the display of questions
    private final Lifeline lifeline; // Manages lifeline functionality
    private final Scanner scan = new Scanner(System.in); // Reads user input
    private boolean answered; // Indicates whether the current question has been answered
    private boolean gameRunning; // Indicates whether the game is currently running

    /**
     * Constructor to initialize the game logic with the player, question
     * loader, and lifeline objects.
     *
     * @param player The player participating in the game.
     * @param questions The object responsible for loading and providing
     * questions.
     * @param lifeline The object managing lifeline usage.
     */
    public GameLogic(Player player, QuestionFileReader questions, Lifeline lifeline) {
        this.player = player;
        this.questions = questions;
        this.lifeline = lifeline;
        this.countdownTimer = new CountdownTimer(answered);
        this.answered = false;
        this.gameRunning = false;
    }

    /**
     * Starts the game by welcoming the player, displaying the start message,
     * and entering the main game loop where questions are presented and
     * handled.
     */
    @Override
    public void startGame() {
        gameRunning = true;
        message.welcome(player.getName());
        message.startBanner();
        promptForStart(); // Wait for player to be ready
        message.startBanner2();
        player.setScore(0); // Initialize player score to zero

        while (gameRunning) {
            startNewQuestionRound(); // Start a new round with a question
        }
    }

    /**
     * Prompts the player to start the game by pressing 'y'.
     */
    private void promptForStart() {
        String userInput;
        do {
            userInput = scan.nextLine();
            if (!inputValidator.checkReadyInput(userInput)) {
                System.out.println("Press y when ready!");
            }
        } while (!inputValidator.checkReadyInput(userInput));
    }

    /**
     * Initiates a new question round by presenting a question, starting the
     * countdown, and handling user input for that round.
     */
    private void startNewQuestionRound() {
        answered = false; // Reset answered state
        questionManager.showNextQuestion(questions, lifeline, player);
        countdownTimer.setAnswered(false);
        countdownTimer.startCountDown(15); // Start countdown with 15 seconds

        handleUserAnswers(); // Handle the player's answer input
        countdownTimer.setAnswered(true); // Stop the countdown when answered
    }

    /**
     * Handles user input for answering questions and processes the input
     * accordingly.
     */
    private void handleUserAnswers() {
        String userInput;

        while (!answered) {
            userInput = scan.nextLine().toLowerCase();
            if (inputValidator.checkAnswerInput(userInput)) {
                if (countdownTimer.hasTimerRunOut()) {
                    handleTimeOut(); // Handle timeout scenario
                    return;
                } else {
                    processUserInput(userInput); // Process the user's valid input
                }
            } else {
                System.out.println("Invalid input! Please try again."); // Prompt for correct input
            }
        }
    }

    /**
     * Processes the user's input, determining if the answer is correct,
     * incorrect, or if the player wants to use a lifeline or quit the game.
     *
     * @param userInput The input provided by the player.
     */
    private void processUserInput(String userInput) {
        answered = true;
        int milliseconds = 2000;
        countdownTimer.setAnswered(true);

        if (userInput.equals(questions.getAnswer())) {
            TimeUtil.pause(milliseconds);
            handleCorrectAnswer();
        } else if (userInput.equalsIgnoreCase("e")) {
            processLifelineInput();
        } else if (userInput.equalsIgnoreCase("f")) {
            handleQuit();
        } else {
            TimeUtil.pause(milliseconds);
            handleIncorrectAnswer();
        }
    }

    /**
     * Processes the use of a lifeline if available, allowing the player to
     * choose and use a lifeline.
     */
    private void processLifelineInput() {
        if (player.isHasLifeline()) {
            String lifelineInput = handleLifeline();
            processUserInput(lifelineInput); // Handle the input after using lifeline
        } else {
            System.out.println("Sorry " + player.getName() + ", you have no lifelines remaining.");
            String input;
            do {
                System.out.println("Please enter a valid answer or type 'f' to quit:");
                input = scan.nextLine();
            } while (!inputValidator.checkAnswerInput(input) && !input.equalsIgnoreCase("f"));
            processUserInput(input); // Handle the new input directly
        }
    }

    /**
     * Manages the selection and use of a lifeline, prompting the player for
     * input.
     *
     * @return The player's input after using a lifeline.
     */
    private String handleLifeline() {
        lifeline.chooseLifeline(questions, player);
        String input;
        do {
            input = scan.nextLine();
            if (!inputValidator.checkAnswerFromLifelineInput(input)) {
                System.out.println("Please enter a valid input");
            }
        } while (!inputValidator.checkAnswerFromLifelineInput(input));
        return input;
    }

    /**
     * Handles the scenario when the player provides the correct answer.
     */
    private void handleCorrectAnswer() {
        System.out.println("\nCorrect!");
        player.setScore(PrizeLevel.getAmountByQuestionLevel(questionManager.getQCount()));

        if (player.getScore() == 1000000) {
            winGame(); // Handle winning the game
        }
    }

    /**
     * Handles the scenario when the player wins the game by reaching the
     * maximum score.
     */
    private void winGame() {
        message.endMessage(player.getName(), player.getScore());
        stopGame(); // Stop the game after winning
    }

    /**
     * Handles the scenario when the player chooses to quit the game.
     */
    private void handleQuit() {
        System.out.println("You chose to quit the game.");
        message.endMessage(player.getName(), player.getScore());
        stopGame(); // Stop the game when the player quits
    }

    /**
     * Handles the scenario when the player provides an incorrect answer
     * then ends the game.
     */
    private void handleIncorrectAnswer() {
        System.out.println("\nIncorrect! Unfortunately the answer is " + questions.getAnswer());
        message.endMessage(player.getName(), player.getScore());
        stopGame(); // Stop the game after incorrect answer
    }

    /**
     * Handles the scenario when the player runs out of time to answer, 
     * prompting an out of time message then ending the game.
     */
    private void handleTimeOut() {
        message.endMessage(player.getName(), player.getScore());
        stopGame(); // Stop the game after timeout
    }

    /**
     * Stops the game, setting the gameRunning flag to false.
     */
    @Override
    public void stopGame() {
        gameRunning = false;
    }
}
