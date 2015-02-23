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
        if(this.score() >= 10){
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
        if(this.balls.size() == 1 && this.balls.get(0).getPins() == numberPins) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isSpare() {
        if(this.isStrike()){
            return false;
        }
        if(this.balls.size() == 2) {
            int ballone = this.balls.get(0).getPins();
            int balltwo = this.balls.get(1).getPins();
            int balls = ballone + balltwo;
            if(balls == 10){
                return true;
            }
        }
        return false;
    }


    @Override
    public int addBonus(int value){
        return this.score();
    }
}
