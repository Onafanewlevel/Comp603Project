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

        while (gameRunning) {
            startNewQuestionRound();
        }
        scan.close();
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
        // Show the next question
        answered = false;
        questionManager.showNextQuestion(questions, lifeline);
        // Start Countdown when next question in initiated.
        countdownTimer.setAnswered(false);
        countdownTimer.startCountDown(15);
        // Handle user input
        String userInput;
        while (!answered) {  // Continue prompting until a valid answer or timeout
            userInput = scan.nextLine();

            if (countdownTimer.hasTimerRunOut()) {
                handleTimeOut();
            } else if (userInputHandler.checkAnswerInput(userInput)) {
                handleUserInput(userInput);
                answered = true;  // Mark as answered to stop the countdown
            } else {
                System.out.println("Invalid input! Please try again.");
            }
        }
        // Ensure countdown stops if the input is provided or if time runs out
        countdownTimer.setAnswered(true);

    }

    private void handleUserInput(String userInput) {
        answered = true;
        countdownTimer.setAnswered(true);

        if (userInput.equalsIgnoreCase(questions.getAnswer())) {
            Utils.pause(2000);
            handleCorrectAnswer();
        } else if (userInput.equalsIgnoreCase("e")) {
            handleLifeline();
        } else if (userInput.equalsIgnoreCase("f")) {
            handleQuit();
        } else {
            Utils.pause(2000);
            handleIncorrectAnswer();
        }
    }

    private void handleCorrectAnswer() {
        System.out.println("\nCorrect!");
    }

    private void handleLifeline() {
        lifeline.useLifeline(questions);
    }

    private void handleQuit() {
        System.out.println("You chose to quit the game.");
        player.setScore(PrizeMoney.getPrizeByQuestionNumber(questionManager.getQCount()));
        message.endMessage(player.getName(), player.getScore());
        stopGame();
    }

    private void handleIncorrectAnswer() {
        System.out.println("\nIncorrect! Unfortunately the answer is " + questions.getAnswer());
        player.setScore(PrizeMoney.getPrizeByQuestionNumber(questionManager.getQCount()));
        message.endMessage(player.getName(), player.getScore());
        stopGame();
    }

    private void handleTimeOut() {
        player.setScore(PrizeMoney.getPrizeByQuestionNumber(questionManager.getQCount()));
        message.endMessage(player.getName(), player.getScore());
        stopGame();
        System.exit(0);
    }

    @Override
    public void stopGame() {
        gameRunning = false;
    }
}
