package de.hfu;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testdenqueue() {
    	assertTrue(Util.istErstesHalbjahr(1));
    	assertTrue(Util.istErstesHalbjahr(6));
    	assertTrue(Util.istErstesHalbjahr(7));
    }
}
