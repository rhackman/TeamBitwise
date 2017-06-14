package com.frontlineed.teambitwise.testsjunit4;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;

/**
 * Created by rhackman on 6/14/2017.
 */
@Category(IGoodTestsCategory.class)
public class TestsAdvanced {

    @Test
    public void TestIsMatcher(){
        assertThat(12,is(3*4));
    }

    @Test
    public void TestAllOfMatcher(){
        assertThat(12,allOf(is(3*4),is(2*6),is(12*1),is(6+6)));
    }
}
