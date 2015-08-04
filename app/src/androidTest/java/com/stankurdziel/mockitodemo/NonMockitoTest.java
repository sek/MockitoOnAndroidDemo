package com.stankurdziel.mockitodemo;

import junit.framework.TestCase;

public class NonMockitoTest extends TestCase {

    public void testTrivialStuff() {
        assertEquals("Hello World!", "Hello " + "World" + "!");
        assertEquals(5, 7 - 2);
    }
}
