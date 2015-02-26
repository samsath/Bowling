package com.samhipwell;

import java.util.ArrayList;

/**
 * Created by sam on 22/02/15.
 */
public class TenthFrame implements Frame {

    private ArrayList<Balls> balls;
    private int frameIndex = 0;
    private int extraPoints = 0;

    private int numberPins = 0;

    public TenthFrame(int numberPins) {
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
        if(balls == null){
            this.balls = new ArrayList<Balls>();
        }
        this.balls.add(ball);
        this.frameIndex++;

        return ball.getPins();
    }

    @Override
    public boolean rollAgain() {
        if(this.balls == null){
            return true;
        }
        if(this.balls.size() <= 1){
            return true;
        }
        return this.score() >= numberPins;
    }

    @Override
    public boolean isStrike() {
        return this.balls.size() == 1 && this.balls.get(0).getPins() == numberPins;
    }

    @Override
    public boolean isSpare() {
        return this.balls.size() == 2 && this.score() == numberPins;
    }


    @Override
    public int addBonus(int value){
        return 0;
    }

    @Override
    public int getBall(int ball) {
        if(this.balls.size() >= ball) {
            return this.balls.get(ball).getPins();
        }else{
            return 0;
        }
    }
}
