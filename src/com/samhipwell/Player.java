package com.samhipwell;


public interface Player {

    String getName();
    String toString();
    Frame play(int frame);
    void checkPoints();
    String getScore();
}
