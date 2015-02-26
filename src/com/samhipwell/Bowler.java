package com.samhipwell;

import java.util.ArrayList;

/**
 * Created by sam on 22/02/15.
 */
public class Bowler implements Player {
    /*
     * This is the main class which implements the Player. Here it keeps a record of each bowlers frames and certain
     *  specifications for how the game will work.
     */
    private String name;  // Name of the bowler
    private int numberofFrames; // number of frames in the game
    private ArrayList<Frame> frames; // frame list

    private static final int NUMBER_OF_PINS = 10;

    public Bowler(String name, int games) {
        /*
         * This is the constructor for the bowler so it gets the person's name and how many frames they want to play.
         */
        this.name = name;
        this.numberofFrames = games;
    }

    public String getName() {
        /*
         * Returns the bowlers Name
         */
        return name;
    }

    public String toString(){
        return "Bowler [name="+name+"]";
    }

    public Frame play(int frame){
        /*
         * Produces the certain frame for the frame so if it is not the last frame then a NormalFrame class is used, else
         *  the TenthFrame class is used so that it can hold 3 balls instead of 2. This fucntion will return the currrent
         *  frame to the game code so that it can be played.
         */
        if(this.frames == null) {
            this.frames = new ArrayList<Frame>();
        }
        if(frame != this.numberofFrames -1){
            this.frames.add(frame, new NormalFrame(NUMBER_OF_PINS));
        }else{
            this.frames.add(frame, new TenthFrame(NUMBER_OF_PINS));
        }
        return this.frames.get(frame);
    }

    public void checkPoints(){
        /*
         * This function goes through the previous frames and works out if they need any more points and if so adds them
         *  to the frame. It is separated into Strike and Spares as each one requires a different addition of points.
         */
        if(this.frames != null && this.frames.size() > 2){
            for(int f = 0; f < this.frames.size(); f++){
                if(this.frames.get(f).isStrike()){
                    int ballcount = 0;
                    int ballindex = 0;
                    int extraframe = 1;
                    int extrascore = 0;
                    while(ballcount <= 1){
                        int result = this.frames.get(f+extraframe).getBall(ballindex);
                        if(result == -1){
                            extraframe++;
                            ballindex = 0;
                        }else{
                            extrascore += result;
                            ballcount++;
                            ballindex++;
                        }
                    }
                    this.frames.get(f).addBonus(extrascore);
                }
                if(this.frames.get(f).isSpare()){
                    int ballcount = 0;
                    int ballindex = 0;
                    int extraframe = 1;
                    int extrascore = 0;
                    while(ballcount < 1){
                        int result = this.frames.get(f+extraframe).getBall(ballindex);
                        if(result == -1){
                            extraframe++;
                            ballindex = 0;
                        }else{
                            extrascore += result;
                            ballcount++;
                            ballindex++;
                        }
                    }
                    this.frames.get(f).addBonus(extrascore);
                }
            }
        }
    }

    public String getScore(){
        /*
         * This function returns the bowlers score will extra point or not.
         */
        if(this.frames != null){
            String returnValue = this.name;
            int total =0;
            for(int f =0; f<this.frames.size(); f++){
                total += this.frames.get(f).score();
                returnValue += " | "+this.frames.get(f).score();
            }
            return returnValue += " | total=" + total;
        }else{
            return "None";
        }
    }

}
