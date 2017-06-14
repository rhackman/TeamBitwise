package com.frontlineed.teambitwise.testsjunit4;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotSame;

/**
 * Created by rhackman on 6/14/2017.
 */
public class TestsFailedIgnored {

    @Test
    public void TestAlwaysFails() {
        System.out.println("Test Always Fails");
        fail("This test always fails. Comment this line, or @Ignore to pass it.");
    }

    @Test
    @Ignore
    public void TestIgnored() {
        System.out.println("Test Ignored");
        assertEquals("Numbers not equal.",5,"Hello!".length());
    }

    @Test(timeout = 5) // 5 milliseconds
    public void TestTimesOut() {
        System.out.println("Test Times Out");

        int j = 0;
        for(int i = 0; i < 10000000; i++)
        {
            j+=2;
        }
    }
}
