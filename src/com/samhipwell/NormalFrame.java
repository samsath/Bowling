package com.samhipwell;

import java.util.ArrayList;

/**
 * Created by sam on 22/02/15.
 */
public class NormalFrame implements Frame {

    private ArrayList<Balls> balls;
    private int frameIndex = 0;
    private int extraPoints = 0;
    private int numberPins = 0;

    public NormalFrame(int numberPins) {
        this.numberPins = numberPins;
    }

    @Override
    public int score() {
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
        if(this.balls == null){
            this.balls = new ArrayList<Balls>();
        }
        if(this.score() >= numberPins){
            return 0;
        }else {
            this.balls.add(ball);
            this.frameIndex++;
            return ball.getPins();
        }
    }

    @Override
    public boolean rollAgain() {
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
        return this.balls.size() == 1 && this.score() == numberPins;
    }

    @Override
    public boolean isSpare() {
        return this.balls.size() == 2 && this.score() == numberPins;
    }


    @Override
    public int addBonus(int value){
        this.extraPoints = value;
        return this.score();
    }

    @Override
    public int getBall(int ball) {
        if(this.balls.size() >= ball+1) {
            return this.balls.get(ball).getPins();
        }else{
            return -1;
        }
    }
}
