package com.samhipwell;

import java.util.ArrayList;

/**
 * Created by sam on 22/02/15.
 */
public class Bowler {
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

    public String getScore(){

        if(this.frames != null){
            String returnValue = this.name;
            int total =0;
            for (int f =0; f<this.frames.size(); f++){
                total += this.frames.get(f).score();
                returnValue += " | "+this.frames.get(f).score();
            }
            return returnValue += " | total=" + total;
        }else{
            return "None";
        }
    }

}
