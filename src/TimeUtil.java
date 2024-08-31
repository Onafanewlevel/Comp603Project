
/**
 * The TimeUtil class provides utility methods related to time management in the game.
 * Currently, it includes a method to pause the execution for a specified number of milliseconds.
 *
 * @author Setefano Muller
 * @author Tharuka Rodrigo
 */
public class TimeUtil {

    /**
     * Pauses the execution of the program for a specified number of
     * milliseconds. This method uses Thread.sleep to create a delay in the
     * game, which can be used to enhance the user experience by adding dramatic
     * pauses or allowing time for the player to read the information displayed
     * on the screen.
     *
     * @param milliseconds The number of milliseconds to pause the program.
     */
    public static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds); // Pause the current thread for the specified duration
        } catch (InterruptedException e) {
        }
    }
}
