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

        if((this.frameIndex == 0|| this.frameIndex == 1) && ball.getPins() == 10){
            return 0;
        }

        return ball.getPins();
    }

    @Override
    public boolean rollAgain() {
        if(this.balls == null){
            return true;
        }


        if(this.balls.get(0).getPins() ==10){
            if(this.balls.get(1) != null && this.balls.get(10).getPins() == 10){
                return true;
            }else if(this.balls.get(1) == null){
                return true;
            }
        }
        if(this.balls.size() < 3 ) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isStrike() {
        if(this.balls.size() == 1) {
            if(this.balls.get(0).getPins() == numberPins){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isSpare() {
        return false;
    }


    @Override
    public int addBonus(int value){
        return this.score();
    }
}
