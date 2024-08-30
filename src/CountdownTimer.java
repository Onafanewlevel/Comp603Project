/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Onafanewlevel
 */
public class CountdownTimer {

    private boolean answered;  // Shared state with the game to know if the player has answered

    public CountdownTimer(boolean answered) {
        this.answered = answered;
    }

    public void startCountDown(int seconds) {
        Thread countdownThread = new Thread(() -> {
            for (int i = seconds; i > 0; i--) {
                if (answered) {
                    return;
                }
                System.out.print(i + " ");
                Utils.pause(1000);
            }
            if (!answered) {
                System.out.println("Time's up!");
                answered = true;  // Mark as answered to stop user input
            }
        });
        countdownThread.start();  // Start the countdown thread
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }
}

