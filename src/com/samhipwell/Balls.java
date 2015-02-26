package com.samhipwell;


public class Balls {
    /*
     * Ball class which holds the ball values.
     */
    private int pins; // Pin down number

    public Balls(int pins){
        /*
         * Sets the amount of pins knocked down and if the number added is greater than 10 the number of pins then it
         *  returns an error.
         */
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
