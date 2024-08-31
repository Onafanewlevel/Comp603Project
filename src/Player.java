
/**
 * The Player class represents a contestant in the quiz game.
 * It maintains the player's name, score, and lifeline status.
 * The class provides methods to get and set these attributes,
 * allowing other parts of the program to interact with and update
 * the player's state throughout the game.
 *
 * @author Setefano Muller
 * @author Tharuka Rodrigo
 */
public class Player {

    private String name; // The player's name
    private int score; // The player's current score
    private boolean hasLifeline; // Indicates if the player still has any lifelines available

    /**
     * Constructor to initialize a new Player with a given name. The score is
     * set to 0 and lifelines are available by default.
     *
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
        this.score = 0; // Initialize score to 0
        this.hasLifeline = true; // Lifelines are available by default
    }

    /**
     * Gets the player's name.
     *
     * @return The name of the player.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the player's name.
     *
     * @param name The name to set for the player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the player's current score.
     *
     * @return The current score of the player.
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the player's score.
     *
     * @param score The score to set for the player.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Checks if the player has any lifelines remaining.
     *
     * @return true if the player has lifelines available, false otherwise.
     */
    public boolean isHasLifeline() {
        return hasLifeline;
    }

    /**
     * Sets the player's lifeline availability status.
     *
     * @param hasLifeline true if the player has lifelines available, false
     * otherwise.
     */
    public void setHasLifeline(boolean hasLifeline) {
        this.hasLifeline = hasLifeline;
    }
}
