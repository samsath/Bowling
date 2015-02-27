package com.samhipwell;

import org.junit.Test;

import static org.junit.Assert.*;

public class TenthFrameTest {

    int numberPins = 10;

    @Test
    public void testScoreInSpare() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(6));
        frames.addBall(new Balls(4));
        assertEquals(numberPins, frames.score());
    }

    @Test
    public void testScoreInDoubleStrike() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(numberPins));
        frames.addBall(new Balls(numberPins));
        assertEquals(numberPins * 2, frames.score());
    }

    @Test
    public void testScoreisZero() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        assertEquals(0, frames.score());
    }

    @Test
    public void testAddBallOneStrike() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(numberPins));
        assertEquals(numberPins, frames.score());
    }

    @Test
    public void testAddBallTwoStrike() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(numberPins));
        frames.addBall(new Balls(numberPins));
        assertEquals(numberPins*2, frames.score());
    }

    @Test
    public void testAddBallThreeStrike() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(numberPins));
        frames.addBall(new Balls(numberPins));
        frames.addBall(new Balls(numberPins));
        assertEquals(numberPins*3, frames.score());
    }

    @Test
    public void testRollAgainWith1Strike() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(numberPins));
        assertTrue(frames.rollAgain());
    }

    @Test
    public void testRollAgainWithTwoStrike() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(numberPins));
        frames.addBall(new Balls(numberPins));
        assertTrue(frames.rollAgain());
    }

    @Test
    public void testRollAgainWithSpare() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(4));
        frames.addBall(new Balls(6));
        assertTrue(frames.rollAgain());
    }

    @Test
    public void testRollAgainWithNoSpare() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(4));
        frames.addBall(new Balls(4));
        assertFalse(frames.rollAgain());
    }

    @Test
    public void testRollAgainWithOneBall() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(4));
        assertTrue(frames.rollAgain());
    }

    @Test
    public void testRollAgainWithThreeStrike() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(numberPins));
        frames.addBall(new Balls(numberPins));
        frames.addBall(new Balls(numberPins));
        assertFalse(frames.rollAgain());
    }

    @Test
    public void testRollAgainWithTwoOddNumber() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(1));
        frames.addBall(new Balls(2));
        assertFalse(frames.rollAgain());
    }

    @Test
    public void testIsStrikewith10() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(numberPins));
        assertTrue(frames.isStrike());
    }

    @Test
    public void testIsStrikewith5() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(5));
        assertFalse(frames.isStrike());
    }

    @Test
    public void testIsStrikewithTwoBalls() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(5));
        frames.addBall(new Balls(5));
        assertFalse(frames.isStrike());
    }

    @Test
    public void testIsStrikewithTwoBallsOdds() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(5));
        frames.addBall(new Balls(3));
        assertFalse(frames.isStrike());
    }

    @Test
    public void testIsSpare() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(5));
        frames.addBall(new Balls(5));
        assertTrue(frames.isSpare());
    }

    @Test
    public void testIsSpareWhenNot() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(5));
        frames.addBall(new Balls(2));
        assertFalse(frames.isSpare());
    }

    @Test
    public void testIsSpareWithThreeBalls() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(5));
        frames.addBall(new Balls(4));
        frames.addBall(new Balls(1));
        assertFalse(frames.isSpare());
    }

    @Test
    public void testIsSpareWhenStrike() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(10));
        assertFalse(frames.isSpare());
    }

    @Test
    public void testAddBonus() throws Exception {
        Frame frames =  new TenthFrame(numberPins);
        frames.addBall(new Balls(5));
        frames.addBonus(5);
        assertEquals(5, frames.score());
    }
}