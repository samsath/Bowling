package com.samhipwell;


public class Main {

    public static void main(String[] args) {
        Games game = new CommandLine();
        if(game.setup()){
            game.play();
        }

    }


}
