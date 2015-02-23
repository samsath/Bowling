package com.samhipwell;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BallsTest {


    @Test(expected = IndexOutOfBoundsException.class)
    public void testBallSetupToMuch(){
        Balls balls = new Balls(11);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testBallSetupUnder(){
        Balls balls = new Balls(-1);
    }

    @Test
    public void testBallSetupRight() throws Exception{
        Balls balls = new Balls(5);
        assertFalse(balls == null);
    }

    @Test
    public void testGetPins() throws Exception {
        Balls balls = new Balls(5);
        assertEquals(5, balls.getPins());
    }
}