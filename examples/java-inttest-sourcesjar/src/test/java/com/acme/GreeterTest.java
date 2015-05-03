package com.acme;
import org.junit.Test;
import static org.junit.Assert.*;

public class GreeterTest {
    @Test
    public void testGreeter() {
    	Greeter greeter = new Greeter();
        assertEquals("Hello, Bordeaux!", greeter.greet("Bordeaux"));
    }
}
