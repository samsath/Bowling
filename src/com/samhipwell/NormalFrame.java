package com.samhipwell;

import java.util.ArrayList;


public class NormalFrame implements Frame {

    /*
     * This is the class for the normal frames so frames not including the last one.
     */
    private ArrayList<Balls> balls; // List of balls per frame
    private int extraPoints = 0; // The amount of extra points added.
    private int numberPins = 0; // number of pins left.

    public NormalFrame(int numberPins) {
        this.numberPins = numberPins;
    }

    @Override
    public int score() {
        /*
         * This function goes through each ball in the list and gets te pin count then adds the extraPoints to the pins
         *  to return the total points for this frame.
         */
        if(this.balls == null){
            return 0;
        }
        int value = 0;
        for(int i=0; i<this.balls.size(); i++){
            value += this.balls.get(i).getPins();
        }
        value += extraPoints;
        return value;
    }

    @Override
    public int addBall(Balls ball) {
        /*
         * Adds the ball to the list, if there isn't any balls there yet then if initiated the list.
         */
        if(this.balls == null){
            this.balls = new ArrayList<Balls>();
        }
        if(this.score() >= numberPins){
            return 0;
        }else {
            this.balls.add(ball);
            return ball.getPins();
        }
    }

    @Override
    public boolean rollAgain() {
        /*
         * This function check if the player can roll again so if the first ball isn't a strike and they have played no
         * more than 2 balls. If they have then they wont be able to through again and will move to the next player.
         */
        if(this.balls == null){
            return true;
        }
        if(this.balls.size() == 2 || this.isStrike()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isStrike() {
        /*
         * Checks if this frame is a strike be a quick return statment.
         */
        return this.balls.size() == 1 && this.score() == numberPins;
    }

    @Override
    public boolean isSpare() {
        /*
         * Checks if this frame is a spare be a quick return statment.
         */

        return this.balls.size() == 2 && this.score() == numberPins;
    }


    @Override
    public int addBonus(int value){
        /*
         * If the bowler works out that there is more points to be awarded to this player on this frame. This function will
         * overwrite the value so there wont be a chance to accumulate to many points.
         */
        this.extraPoints = value;
        return this.score();
    }

    @Override
    public int getBall(int ball) {
        /*
         * Returns the ball value if there is a ball of that type else it returns a unusable number to the other function.
         */
        if(this.balls.size() > ball) {
            return this.balls.get(ball).getPins();
        }else{
            return 9999;
        }
    }

    @Override
    public int pinsLeft() {
        /*
         * Returns the Score as it allows the play function to work out how many is left.
         */
        return this.score();
    }
}
