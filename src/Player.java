/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Onafanewlevel
 */
public class Player {

    private String name;
    private int score;
    private boolean hasLifeline;

    public Player(String name) {
        this.name = name;
        score = 0;
        hasLifeline = true;
    }

    public void increaseScore(int score) {
        this.score += score;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @return the hasLifeline
     */
    public boolean isHasLifeline() {
        return hasLifeline;
    }

    /**
     * @param hasLifeline the hasLifeline to set
     */
    public void setHasLifeline(boolean hasLifeline) {
        this.hasLifeline = hasLifeline;
    }
}
