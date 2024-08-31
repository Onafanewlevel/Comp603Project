
/**
 * The CountdownTimer class manages a countdown timer for a quiz game.
 * It provides functionality to start a countdown from a specified number
 * of seconds and checks if the timer has run out. The timer stops if an
 * answer is provided before it reaches zero.
 *
 * @author Setefano Muller
 * @author Tharuka Rodrigo
 */
public class CountdownTimer {

    private Messages message; // Message handler to show time's up message
    private boolean answered; // Flag to indicate if the question has been answered
    private boolean timerRunOut; // Flag to indicate if the timer has run out

    public CountdownTimer(boolean answered) {
        message = new Messages();
        this.answered = answered;
        this.timerRunOut = false; // Initialize timerRunOut to false
    }

    /**
     * Starts a countdown from the specified number of seconds. The countdown
     * runs on a separate thread and stops if the question is answered.
     */
    public void startCountDown(int seconds) {
        Thread countdownThread = new Thread(() -> {
            for (int i = seconds; i > 0; i--) {
                if (answered) {
                    return; // Exit the loop if the question is answered
                }
                System.out.print(i + " "); // Display the countdown
                TimeUtil.pause(1000); // Pause for 1 second
            }
            if (!answered) {
                message.timesUp(); // Display time's up message
                timerRunOut = true; // Set timerRunOut to true if timer expired
                answered = true; // Mark question as answered due to timeout
            }
        });
        countdownThread.start(); // Start the countdown thread
    }

    /**
     * Checks if the timer has run out.
     */
    public boolean hasTimerRunOut() {
        return timerRunOut;
    }

    /**
     * Sets the answered state of the question.
     */
    public void setAnswered(boolean answered) {
        this.answered = answered;
        if (answered) {
            timerRunOut = false; // Reset timerRunOut if question is answered
        }
    }
}
