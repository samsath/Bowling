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
}