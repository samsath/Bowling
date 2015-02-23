package com.samhipwell;

/**
 * Created by sam on 22/02/15.
 */
public class Balls {
    private int pins;

    public Balls(int pins){
        if(pins > 10 || pins < 0){
            throw new IndexOutOfBoundsException("Pins wrong number");
        }else {
            this.pins = pins;
        }
    }

    public final int getPins(){
        return pins;
    }
}
