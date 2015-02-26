package com.samhipwell;

/**
 * Created by sam on 22/02/15.
 */
public interface Frame {
    int score();
    int addBall(Balls ball);
    boolean rollAgain();
    boolean isStrike();
    boolean isSpare();
    int addBonus(int value);
    int getBall(int ball);
}
