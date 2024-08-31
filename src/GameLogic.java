/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Onafanewlevel
 */
import java.util.Scanner;

public class GameLogic implements GameControl {

    private final Player player;
    private final Messages message = new Messages();
    private final QuestionLoader questions;
    private final UserInputHandler userInputHandler = new UserInputHandler();
    private final CountdownTimer countdownTimer;
    private final QuestionManager questionManager = new QuestionManager();
    private final Lifeline lifeline;
    private final Scanner scan = new Scanner(System.in);
    private boolean answered;
    private boolean gameRunning;

    public GameLogic(Player player, QuestionLoader questions, Lifeline lifeline) {
        this.player = player;
        this.questions = questions;
        this.lifeline = lifeline;
        this.countdownTimer = new CountdownTimer(answered);
        this.answered = false;
        this.gameRunning = false;
    }

    @Override
    public void startGame() {
        gameRunning = true;
        message.welcome(player.getName());
        message.startBanner();
        promptForStart();
        message.startBanner2();
        player.setScore(0);

        while (gameRunning) {
            startNewQuestionRound();
        }
    }

    private void promptForStart() {
        String userInput;
        do {
            userInput = scan.nextLine();
            if (!userInputHandler.checkReadyInput(userInput)) {
                System.out.println("Press y when ready!");
            }
        } while (!userInputHandler.checkReadyInput(userInput));
    }

    private void startNewQuestionRound() {
        answered = false;
        questionManager.showNextQuestion(questions, lifeline, player);
        countdownTimer.setAnswered(false);
        countdownTimer.startCountDown(15);

        handleUserAnswers();
        countdownTimer.setAnswered(true); // Ensure countdown stops
    }

    private void handleUserAnswers() {
        String userInput;
        while (!answered) {
            if (countdownTimer.hasTimerRunOut()) {
                handleTimeOut();
                return; // Exit if the timer has run out
            }

            userInput = scan.nextLine();
            if (userInputHandler.checkAnswerInput(userInput)) {
                processUserInput(userInput);
            } else {
                System.out.println("Invalid input! Please try again.");
            }
        }
    }

    private void processUserInput(String userInput) {
        answered = true;
        int milliseconds = 0;
        countdownTimer.setAnswered(true);

        if (userInput.equalsIgnoreCase(questions.getAnswer())) {
            Utils.pause(milliseconds);
            handleCorrectAnswer();
        } else if (userInput.equalsIgnoreCase("e")) {
            processLifelineInput();
        } else if (userInput.equalsIgnoreCase("f")) {
            handleQuit();
        } else {
            Utils.pause(milliseconds);
            handleIncorrectAnswer();
        }
    }

    private void processLifelineInput() {
        if (player.isHasLifeline()) {
            String lifelineInput = handleLifeline();
            processUserInput(lifelineInput); // Instead of recursion, handle input directly
        } else {
            System.out.println("Sorry " + player.getName() + ", you have no lifelines remaining.");
            String input;
            do {
                System.out.println("Please enter a valid answer or type 'f' to quit:");
                input = scan.nextLine();
            } while (!userInputHandler.checkAnswerInput(input) && !input.equalsIgnoreCase("f"));
            processUserInput(input); // Handle new input directly
        }
    }

    private String handleLifeline() {
        lifeline.chooseLifeline(questions, player);
        String input;
        do {
            input = scan.nextLine();
            if (!userInputHandler.checkAnswerFromLifelineInput(input)) {
                System.out.println("Please enter a valid input");
            }
        } while (!userInputHandler.checkAnswerFromLifelineInput(input));
        return input;
    }

    private void handleCorrectAnswer() {
        System.out.println("\nCorrect!");
        System.out.println("Count: " + questionManager.getQCount());
        player.setScore(PrizeMoney.getPrizeByQuestionNumber(questionManager.getQCount()));

        if (player.getScore() == 1000000) {
            winGame();
        }
    }

    private void winGame() {
        System.out.println("\nCongratulations, " + player.getName() + "! You have won the game with a score of " + player.getScore() + "!");
        message.endMessage(player.getName(), player.getScore());
        stopGame();
    }

    private void handleQuit() {
        System.out.println("You chose to quit the game.");
        message.endMessage(player.getName(), player.getScore());
        stopGame();
    }

    private void handleIncorrectAnswer() {
        System.out.println("\nIncorrect! Unfortunately the answer is " + questions.getAnswer());
        message.endMessage(player.getName(), player.getScore());
        stopGame();
    }

    private void handleTimeOut() {
        message.endMessage(player.getName(), player.getScore());
        stopGame();
        System.exit(0);
    }

    @Override
    public void stopGame() {
        gameRunning = false;
    }
}
