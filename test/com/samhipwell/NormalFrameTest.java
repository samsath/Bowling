package com.samhipwell;

import org.junit.Test;

import static org.junit.Assert.*;

public class NormalFrameTest {

    int numberPins = 10;

    @Test
    public void testScoreInSpare() throws Exception {

        Frame frames =  new NormalFrame(numberPins);
        frames.addBall(new Balls(6));
        frames.addBall(new Balls(4));
        assertEquals(numberPins, frames.score());
    }

    @Test
    public void testScoreisZero() throws Exception {
        Frame frames =  new NormalFrame(numberPins);
        assertEquals(0, frames.score());
    }

    @Test
    public void testAddBall() throws Exception {
        Frame frames =  new NormalFrame(numberPins);
        frames.addBall(new Balls(5));
        assertEquals(5, frames.score());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddBallofEleven() throws Exception {
        Frame frames =  new NormalFrame(numberPins);
        assertEquals(0, frames.addBall(new Balls(11)));
    }

    @Test
    public void testRollAgainNoBalls() throws Exception {
        Frame frames =  new NormalFrame(numberPins);
        assertTrue(frames.rollAgain());
    }

    @Test
    public void testRollAgainOneBallOfOddNumber() throws Exception {
        Frame frames =  new NormalFrame(numberPins);
        frames.addBall(new Balls(5));
        assertTrue(frames.rollAgain());
    }

    @Test
    public void testRollAgainofStrike() throws Exception {
        Frame frames =  new NormalFrame(numberPins);
        frames.addBall(new Balls(10));
        assertFalse(frames.rollAgain());
    }

    @Test
    public void testRollAgainTwoBallsnoSpare() throws Exception {
        Frame frames =  new NormalFrame(numberPins);
        frames.addBall(new Balls(5));
        frames.addBall(new Balls(3));
        assertFalse(frames.rollAgain());
    }

    @Test
    public void testRollAgainofSpare() throws Exception {
        Frame frames =  new NormalFrame(numberPins);
        frames.addBall(new Balls(3));
        frames.addBall(new Balls(7));
        assertFalse(frames.rollAgain());
    }

    @Test
    public void testIsStrikewith10() throws Exception {
        Frame frames =  new NormalFrame(numberPins);
        frames.addBall(new Balls(numberPins));
        assertTrue(frames.isStrike());
    }

    @Test
    public void testIsStrikewith5() throws Exception {
        Frame frames =  new NormalFrame(numberPins);
        frames.addBall(new Balls(5));
        assertFalse(frames.isStrike());
    }

    @Test
    public void testIsStrikewithTwoBalls() throws Exception {
        Frame frames =  new NormalFrame(numberPins);
        frames.addBall(new Balls(5));
        frames.addBall(new Balls(5));
        assertFalse(frames.isStrike());
    }

    @Test
    public void testIsStrikewithTwoBallsOdds() throws Exception {
        Frame frames =  new NormalFrame(numberPins);
        frames.addBall(new Balls(5));
        frames.addBall(new Balls(3));
        assertFalse(frames.isStrike());
    }

    @Test
    public void testIsSpare() throws Exception {
        Frame frames =  new NormalFrame(numberPins);
        frames.addBall(new Balls(5));
        frames.addBall(new Balls(5));
        assertTrue(frames.isSpare());
    }

    @Test
    public void testIsSpareWhenNot() throws Exception {
        Frame frames =  new NormalFrame(numberPins);
        frames.addBall(new Balls(5));
        frames.addBall(new Balls(2));
        assertFalse(frames.isSpare());
    }

    @Test
    public void testIsSpareWhenStrike() throws Exception {
        Frame frames =  new NormalFrame(numberPins);
        frames.addBall(new Balls(10));
        assertFalse(frames.isSpare());
    }

    @Test
    public void testAddBonus() throws Exception {
        Frame frames =  new NormalFrame(numberPins);
        frames.addBall(new Balls(5));
        frames.addBonus(5);
        assertEquals(10, frames.score());
    }

}