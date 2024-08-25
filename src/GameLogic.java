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
    private Player player;
    private Messages message = new Messages();
    private QuestionLoader questions;
    private UserInputHandler userInputHandler;
    private CountdownTimer countdownTimer;
    private QuestionManager questionManager;
    private Lifeline lifeline;
    private boolean answered;
    private int score;
    private boolean gameRunning;

    public GameLogic(Player player, QuestionLoader questions, Lifeline lifeline) {
        this.player = player;
        this.questions = questions;
        this.userInputHandler = new UserInputHandler();
        this.countdownTimer = new CountdownTimer(answered);
        this.questionManager = new QuestionManager();
        this.lifeline = lifeline;
        this.answered = false;
        this.score = 0;
        this.gameRunning = false;
    }

    @Override
    public void startGame() {
        gameRunning = true;
        message.welcome(player.getName());
        message.startBanner();
        userInputHandler.isPlayerReady();
        message.startBanner2();
        
        while (gameRunning) {
            answered = false;  // Reset the answered flag for each new question
            questionManager.showNextQuestion(questions);  // Show the next question
            countdownTimer.setAnswered(false);  // Reset countdown timer state
            countdownTimer.startCountDown(15);  // Start a 15-second countdown

            String userAnswer = userInputHandler.getPlayerAnswer();
            answered = true;  // Set answered to true to stop the countdown thread
            countdownTimer.setAnswered(true);  // Update countdown timer state

            Utils.pause(2000);  // Optional pause for dramatic effect

            if (userAnswer.equalsIgnoreCase(questions.getAnswer())) {
                System.out.println("\nCorrect!");
                score += 500;
            } else if (userAnswer.equalsIgnoreCase("e")) {
                // Handle lifeline usage
                System.out.println("Using a lifeline...");
                lifeline.useLifeline(questions);
            } else if (userAnswer.equalsIgnoreCase("f")) {
                // Handle quitting the game
                System.out.println("You chose to quit the game.");
                message.endMessage(player.getName(), score);
                stopGame();
                break;  // Exit the game loop
            } else {
                // Handle incorrect answer
                System.out.println("\nIncorrect!");
                message.endMessage(player.getName(), score);
                stopGame();
                break;  // Exit the game loop
            }
        }

        userInputHandler.closeScanner();  // Close the scanner
    }

    @Override
    public void stopGame() {
        gameRunning = false;
    }
}

