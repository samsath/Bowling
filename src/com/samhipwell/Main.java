package com.samhipwell;


public class Main {

    public static void main(String[] args) {
        /*
         * This function will be the starting point of the game and where the interface can be set.
         */
        Games game = new CommandLine(); // CommandLine() or GUI()

        //Runs the game setup then if it returns true the game starts.
        if(game.setup()){
            game.play();
        }
    }
}
