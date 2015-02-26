package com.samhipwell;

import java.util.ArrayList;

/**
 * Created by sam on 22/02/15.
 */
public class Bowler implements Player {
    private String name;
    private int numberofFrames;
    private ArrayList<Frame> frames;

    private static final int NUMBER_OF_PINS = 10;

    public Bowler(String name, int games) {
        this.name = name;
        this.numberofFrames = games;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return "Bowler [name="+name+"]";
    }

    public Frame play(int frame){
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
