package de.hfu;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testUtil() {
    	assertTrue(Util.istErstesHalbjahr(1));
    	assertTrue(Util.istErstesHalbjahr(2));
    	assertTrue(Util.istErstesHalbjahr(3));
    	assertTrue(Util.istErstesHalbjahr(4));
    	assertTrue(Util.istErstesHalbjahr(5));
    	assertTrue(Util.istErstesHalbjahr(6));
    	assertFalse(Util.istErstesHalbjahr(7));
    	assertFalse(Util.istErstesHalbjahr(8));
    	assertFalse(Util.istErstesHalbjahr(9));
    	assertFalse(Util.istErstesHalbjahr(10));
    	assertFalse(Util.istErstesHalbjahr(11));
    	assertFalse(Util.istErstesHalbjahr(12));
    	try {
    		Util.istErstesHalbjahr(0);
    		fail();
    	}
    	catch(IllegalArgumentException e){
    	}
    	try {
    		Util.istErstesHalbjahr(13);
    		fail();
    	}
    	catch(IllegalArgumentException e){  		
    	}
    }
    @Test
    public void testQueue() {
    	Queue tester = new Queue(3);
    	tester.enqueue(5);
    	tester.enqueue(6);
    	tester.enqueue(9);
    	assertEquals(5, tester.dequeue());
    	assertEquals(6, tester.dequeue());
    	assertEquals(9, tester.dequeue());
    	try {
    		tester.dequeue();
    		fail();
    	}
    	catch(IllegalStateException e) {
    		
    	}
    	tester.enqueue(5);
    	assertEquals(5, tester.dequeue());
    	for (int i = 0; i < 1000; i++ ) {
    		tester.enqueue(i);
    	}
    	assertEquals(0, tester.dequeue());
    	assertEquals(1, tester.dequeue());
    	assertEquals(999, tester.dequeue());
    }
}
