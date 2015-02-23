package com.samhipwell;


public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        if(game.setup()){
            game.play();
        }

    }


}
