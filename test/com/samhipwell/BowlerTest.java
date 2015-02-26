package com.samhipwell;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BowlerTest {

    private Bowler user;

    @Before
    public void setUp() throws Exception {
        user = new Bowler("sam",1);
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("sam",user.getName());
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Bowler [name=sam]",user.toString());
    }

    @Test
    public void testPlayFrameIsLastFrame() throws Exception {
        Bowler buser = new Bowler("sam",1);
        Frame play = buser.play(0);
        assertTrue(play instanceof TenthFrame);
    }

    @Test
    public void testPlayFrameIsFirst() throws Exception {
        Bowler buser = new Bowler("sam",2);
        Frame play = buser.play(0);
        assertTrue(play instanceof NormalFrame);
    }

    @Test
    public void testgetScoreWithNoFrames() throws Exception {
        Bowler buser = new Bowler("sam",2);
        assertEquals("None", buser.getScore());
    }

    @Test
    public void testgetScoreWithFrames() throws Exception {
        Bowler buser = new Bowler("sam",4);
        for(int i =0; i < 2; i++){
            Frame play = buser.play(i);
            play.addBall(new Balls(2));
            play.addBall(new Balls(6));
        }
        assertEquals("sam | 8 | 8 | total=16", buser.getScore());
    }

    @Test
    public void testCheckPointsTwoStrikes() throws Exception{
        Bowler buser = new Bowler("sam",4);
        Frame play = buser.play(0);
        play.addBall(new Balls(10));
        Frame play1 = buser.play(1);
        play1.addBall(new Balls(10));
        Frame play2 = buser.play(2);
        play2.addBall(new Balls(4));
        play2.addBall(new Balls(3));
        buser.checkPoints();
        assertEquals("sam | 24 | 17 | 7 | total=48",buser.getScore());
    }

    @Test
    public void testCheckPointsOneStrikes() throws Exception{
        Bowler buser = new Bowler("sam",4);
        Frame play = buser.play(0);
        play.addBall(new Balls(10));
        Frame play1 = buser.play(1);
        play1.addBall(new Balls(5));
        play1.addBall(new Balls(2));
        Frame play2 = buser.play(2);
        play2.addBall(new Balls(4));
        play2.addBall(new Balls(3));
        buser.checkPoints();
        assertEquals("sam | 17 | 7 | 7 | total=31",buser.getScore());
    }

    @Test
    public void testCheckPointsAllStrike() throws Exception{
        Bowler buser = new Bowler("sam",10);
        for(int i =0; i < 9; i++){
            Frame play = buser.play(i);
            play.addBall(new Balls(10));
        }
        Frame play = buser.play(9);
        play.addBall(new Balls(10));
        play.addBall(new Balls(10));
        play.addBall(new Balls(10));
        buser.checkPoints();
        assertEquals("sam | 30 | 30 | 30 | 30 | 30 | 30 | 30 | 30 | 30 | 30 | total=300",buser.getScore());
    }

    @Test
    public void testCheckPointsAllSpare() throws Exception{
        Bowler buser = new Bowler("sam",10);
        for(int i =0; i < 9; i++){
            Frame play = buser.play(i);
            play.addBall(new Balls(5));
            play.addBall(new Balls(5));
        }
        Frame play = buser.play(9);
        play.addBall(new Balls(5));
        play.addBall(new Balls(5));
        play.addBall(new Balls(5));
        buser.checkPoints();
        assertEquals("sam | 15 | 15 | 15 | 15 | 15 | 15 | 15 | 15 | 15 | 15 | total=150",buser.getScore());
    }
}