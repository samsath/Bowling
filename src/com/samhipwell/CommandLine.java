package com.samhipwell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * This is the command line user interface implementation for the game.
 */
public class CommandLine implements Games{
    private static final int NUMBER_OF_PINS = 10; // maximum amount of pins in specification
    private static final int MAXIMUM_AMOUNT_OF_PLAYERS = 6; // maximum amount of players in specification

    private int numberOfGames = 0;

    private ArrayList<Player> bowler;




    public boolean setup(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
         * This while loop is to set how many frames the players want to play.
         * This process goes through a loop asking the user for a number, if the number isn't inputted then they get
         * asked again. Can be skipped if the numberOfGames is pre set to a number;
         */
        while(numberOfGames == 0){
            System.out.print("How many games do you want:");
            String numGames = null;
            try{
                numGames = br.readLine();
                int games = Integer.parseInt(numGames);
                this.numberOfGames = games;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IO error can't reading your response");
            }catch(NumberFormatException e){
                System.out.println("This is not a number please only type a number (1-10).");
            }
        }

        /*
         * This is the loop to add bowlers to the game so it keeps asking them for there name and if they want to
         * continue adding more people till the fixed number of players. Each time it checks the user's input to see if
         * they have inputted a valued entry.
         */
        do {
            System.out.println("Do you want to add new bowler y or n");

            String answer = null;
            try{
                answer = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IO error in reading your response");
            }
            assert answer != null;
            if (answer.matches("y") || answer.matches("Y")){
                if(this.bowler == null) {
                    this.bowler = new ArrayList<Player>();
                }
                System.out.print("Please type in your Name:");
                String userName = null;
                try{
                    userName = br.readLine();
                    this.bowler.add(new Bowler(userName, this.numberOfGames));
                    if(this.bowler.size() == MAXIMUM_AMOUNT_OF_PLAYERS){
                        System.out.println("You have reached the maximum of 6 players");
                        return true;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("IO error can't reading your response");
                }
            } else if(answer.matches("n") || answer.matches("N")){
                return true;
            }else{
                System.out.println("Could not understand input please just type y or n");
            }

        }while(true);
    }

    public void play() {
        if(this.bowler == null) {
            System.out.println("No bowlers added");
            this.setup();
        }
        System.out.println("There are "+this.bowler.size()+" in this game");
        System.out.println("The bowlers are:");
        for(int b = 0; b < this.bowler.size(); b++){
            System.out.println(this.bowler.get(b).getName());
        }
        System.out.println("The game will be played in that order.");

        this.turnPlay();
        this.printResults();
    }

    public void printResults() {
        if(this.bowler != null){
            System.out.println("This is your results:");
            for(int u =0; u<this.bowler.size(); u++){
                System.out.println(this.bowler.get(u).getScore());
            }
        }else{
            System.out.println("No Results");
        }
    }


    private void turnPlay() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int frame = 0; frame < numberOfGames;frame++){
            System.out.println("Round :"+frame);
            for(int u = 0; u<this.bowler.size(); u++){
                System.out.println(this.bowler.get(u).getName()+" Your Up");
                Frame currentFrame = this.bowler.get(u).play(frame);
                do{
                    int leftPins = NUMBER_OF_PINS - currentFrame.score();
                    System.out.println("You have "+leftPins+" pins left");
                    System.out.print("Ball:");
                    String ballInput;
                    int ball;
                    Balls through = null;
                    try{
                        ballInput = br.readLine();
                        ball = Integer.parseInt(ballInput);
                        if(leftPins >= ball) {
                            through = new Balls(ball);
                        }else{
                            System.out.println("Pin knocked over count to high, must be 0-"+leftPins);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NumberFormatException e) {
                        System.out.println("This is not a number please only type a number (1-10).");
                    } catch (IndexOutOfBoundsException e){
                        System.out.println("To many pins counted only 1-10.");
                    }
                    if(through != null) {
                            currentFrame.addBall(through);
                    }
                }while(currentFrame.rollAgain());
                this.bowler.get(u).checkPoints();
            }
        }
    }
}
