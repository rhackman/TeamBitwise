package com.frontlineed.teambitwise.testsjunit4;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rhackman on 6/14/2017.
 */

@RunWith(Parameterized.class)
public class TestsParameterized {

    private int input;
    private int expected;

    @Parameters
    public static List<Object[]> data(){
        return Arrays.asList(new Object[][] {
                {5,10},
                {4,8},
                {2,0},
                {-1,-2},
                {3,6}
        });
    }

    public TestsParameterized(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void test() {
        assertEquals(expected, input*2);
    }
}
