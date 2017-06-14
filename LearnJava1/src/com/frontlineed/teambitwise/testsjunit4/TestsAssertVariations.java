package com.frontlineed.teambitwise.testsjunit4;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotSame;

/**
 * Created by rhackman on 6/14/2017.
 */
@Category(IGoodTestsCategory.class)
public class TestsAssertVariations {

    @Test
    public void TestExpectedStringLength() {
        System.out.println("Test Expected String Length");
        assertEquals("Numbers not equal.",6,"Hello!".length());
    }

    @Test
    public void TestAssertNull() {
        System.out.println("Test Assert Null");
        Object o = null;
        assertNull(o);
    }

    @Category(IBadTestsCategory.class)
    @Test
    public void TestAssertNotNull() {
        System.out.println("Test Assert Not Null");
        String s = "Not null string";
        assertNotNull(s);
    }

    @Test
    public void TestAssertTrue() {
        System.out.println("Test Assert True");
        assertTrue( 2 == 2);
    }

    @Category(IBadTestsCategory.class)
    @Test
    public void TestAssertFalse() {
        System.out.println("Test Assert False");
        assertFalse( 1 == 2);
    }

    @Test
    public void TestAssertSame() {
        System.out.println("Test Assert Same");
        Object o = "Hi";
        Object p = o;
        assertSame(o,p);
    }

    @Category(IBadTestsCategory.class)
    @Test
    public void TestAssertNotSame() {
        System.out.println("Test Assert Not Same");
        Object o = "Hi";
        Object p = "Hi ya!";
        assertNotSame(o,p);
    }
}
