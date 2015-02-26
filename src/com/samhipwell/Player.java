package com.samhipwell;


public interface Player {

    /*
     * Interface for the player of the game incase in time there needs to be a different type of player.
     */
    String getName();
    String toString();
    Frame play(int frame);
    void checkPoints();
    String getScore();
}
