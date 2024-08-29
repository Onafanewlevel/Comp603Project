/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Onafanewlevel
 */
public class CountdownTimer {

    Messages message;
    private boolean answered;  // Shared state with the game to know if the player has answered
    private boolean timerRunOut;

    public CountdownTimer(boolean answered) {
        message = new Messages();
        this.answered = answered;
        this.timerRunOut = false;
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
                message.timesUp();
                timerRunOut = true;
                answered = true;
            }
        });
        countdownThread.start();  // Start the countdown thread
    }

    public boolean hasTimerRunOut() {
        return timerRunOut;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
        if (answered) {
            timerRunOut = false;
        }
    }
}
