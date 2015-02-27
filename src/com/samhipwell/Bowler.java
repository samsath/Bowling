package com.samhipwell;


import org.apache.commons.lang3.StringUtils;

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
    @Override
    public String getName() {
        /*
         * Returns the bowlers Name
         */
        return name;
    }

    @Override
    public String toString(){
        return "Bowler [name="+name+"]";
    }

    @Override
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

    @Override
    public void checkPoints(){
        /*
         * This function goes through the previous frames and works out if they need any more points and if so adds them
         *  to the frame. It is separated into Strike and Spares as each one requires a different addition of points.
         */
        if(this.frames != null){
            for(int f = 0; f < this.frames.size()-1; f++){
                    if(this.frames.get(f).isStrike()) {
                        int ballcount = 0;
                        int ballindex = 0;
                        int extraframe = 1;
                        int extrascore = 0;
                        while (ballcount <= 1) {
                            if(this.frames.size() > f+extraframe) {
                                int result = this.frames.get(f + extraframe).getBall(ballindex);
                                if (result == 9999) {
                                    extraframe++;
                                    ballindex = 0;
                                } else {
                                    extrascore += result;
                                    ballcount++;
                                    ballindex++;
                                }
                            }else{
                                ballcount =2;
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
                        if(this.frames.size() > f+extraframe) {
                            int result = this.frames.get(f + extraframe).getBall(ballindex);
                            if (result == 9999) {
                                extraframe++;
                                ballindex = 0;
                            } else {
                                extrascore += result;
                                ballcount++;
                                ballindex++;
                            }
                        }else{
                            ballcount =1;
                        }
                    }
                    this.frames.get(f).addBonus(extrascore);
                }
            }
        }
    }

    @Override
    public String getScore(){
        /*
         * This function returns the bowlers score will extra point or not.
         */
        if(this.frames != null){
            String strVal = " ";
            String returnScore = StringUtils.repeat(strVal, this.name.length());
            int total =0;
            for(int f =0; f<this.frames.size(); f++){
                int ballScore = this.frames.get(f).score();
                total += ballScore;
                int ballLength = (int)(Math.log10(ballScore)+1);
                if(ballLength == 2){
                    returnScore += "|  "+ballScore+"   ";
                }else if(ballLength == 3) {
                    returnScore += "| "+ballScore+"  ";
                }else{
                    returnScore += "|   "+ballScore+"   ";
                }
            }
            return returnScore += "| total=" + total;
        }else{
            return "None";
        }
    }

    @Override
    public String getPoints(){
    /*
     * This function returns the bowlers points
     */
        if(this.frames != null){
            String returnValue = this.name;
            for(int f = 0; f<this.frames.size();f++){
                for(int b = 0; b<3;b++){
                    int ballv = this.frames.get(f).getBall(b);
                    switch(ballv){
                        case 9999:
                            break;
                        case 10:
                            returnValue += "|  X    ";
                            break;
                        default:
                            int ballLength = (int)(Math.log10(ballv)+1);
                            if(ballLength == 2){
                                returnValue += "| "+ballv;
                            }else if(ballLength == 3) {
                                returnValue += "|"+ballv;
                            }else{
                                returnValue += "|  "+ballv;
                            }
                    }
                }
            }
            return returnValue+"|";
        }else{
            return "None";
        }
    }

}
