package com.samhipwell;

/*
 * This is the interface for the type of interaction for the user, it is so there can be a GUI interface or a command line.
 */
public interface Games {
    boolean setup();
    void play();
    void printResults();
}
