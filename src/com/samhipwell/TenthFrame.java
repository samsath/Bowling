package com.samhipwell;

import java.util.ArrayList;


public class TenthFrame implements Frame {
    /*
     * This is the class for the Last frame.
     */
    private ArrayList<Balls> balls; // List of balls per frame
    private int extraPoints = 0; // The amount of extra points added.

    private int numberPins = 0; // number of pins left.

    public TenthFrame(int numberPins) {
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
        if(balls == null){
            this.balls = new ArrayList<Balls>();
        }
        this.balls.add(ball);

        return ball.getPins();
    }

    @Override
    public boolean rollAgain() {
        /*
         * This function check if the player can roll again so if there is no more than 3 balls and if the first two balls
         *  are more than the numberPins they can roll again.
         */
        if(this.balls == null){
            return true;
        }
        if(this.balls.size() <= 1){
            return true;
        }
        if(this.balls.size() == 3){
            return false;
        }
        return this.score() >= numberPins && this.balls.get(1).getPins() != 0;
    }

    @Override
    public boolean isStrike() {
        /*
         * Checks if this frame is a strike be a quick return statment.
         */
        return this.balls.size() == 1 && this.balls.get(0).getPins() == numberPins;
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
         * As the interface needs to have a addBounse function but this function is not needed to add extra points, the
         * function just returns the current score.
         */
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
         * Returns different values depending on how many balls used and what the score is.
         *  This is due to there being up to three balls and a maximum score of 30 instead of 10.
         */
        if(this.balls == null){
            return 0;
        }
        if(this.balls.size() == 1 && this.balls.get(0).getPins() < 10){
            return this.score();
        }else if(this.balls.size() == 1 && this.balls.get(0).getPins() == 10){
            return 0;
        }
        if(this.balls.size() == 2 && this.score() >= 10){
            return 0;
        }else{
            return this.score();
        }
    }
}
