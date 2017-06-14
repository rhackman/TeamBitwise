package com.frontlineed.teambitwise.testsjunit4;

import org.junit.*;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;

/**
 * Created by rhackman on 6/14/2017.  This is an intro to unit testing with JUnit4.
 * method names in real life should be more descriptive, following a convention
 * similar to: UnitOfWork_InitialCondition_ExpectedResult
 */
public class TestsHelloWorld {


    // ----------- BEFORE AND AFTER METHODS -----------

    @BeforeClass
    public static void before(){
        // Runs once before all test methods. Used for one-time setup.
        System.out.println("Before Class");
    }

    @AfterClass
    public static void after(){
        // Runs once after all test methods. Used for one-time tear down.
        System.out.println("After Class");
    }

    @Before
    public void setUp() throws Exception {
        // Runs before each test method. Used for re-initializing before each test.
        System.out.println("Before ");
    }

    @After
    public void tearDown() throws Exception {
        // Runs after each test method. Used for tearing down after each test.
        System.out.println("After");
    }



    // ----------- TEST METHODS -----------


    @Test
    @Category(IGoodTestsCategory.class)
    public void TestExpectedStringLength() {
        System.out.println("Test Expected String Length");
        assertEquals("Numbers not equal.",6,"Hello!".length());
    }

    @Category({IGoodTestsCategory.class, IBadTestsCategory.class})
    @Test(expected = ArithmeticException.class)
    public void TestThrowsException()throws ArithmeticException {
        System.out.println("Test Throws Exception");
        System.out.println(1/0);
    }
}