package com.frontlineed.teambitwise.testsuites;

import com.frontlineed.teambitwise.testsjunit4.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by rhackman on 6/14/2017.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                TestsHelloWorld.class,
                TestsAssertVariations.class,
                TestsFailedIgnored.class,
                TestsParameterized.class,
                TestsAdvanced.class
        })
public class TestSuiteRunAllTests {
}
