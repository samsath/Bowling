package com.samhipwell;

/**
 * Created by sam on 22/02/15.
 */
public interface Frame {
    /*
     * The interface for the frame code so that there can be a difference between the noraml frames and last one.
     */
    int score();
    int addBall(Balls ball);
    boolean rollAgain();
    boolean isStrike();
    boolean isSpare();
    int addBonus(int value);
    int getBall(int ball);
    int pinsLeft();
}
