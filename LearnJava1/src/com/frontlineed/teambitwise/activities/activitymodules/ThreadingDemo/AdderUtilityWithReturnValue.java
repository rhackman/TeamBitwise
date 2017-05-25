package com.frontlineed.teambitwise.activities.activitymodules.ThreadingDemo;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * Created by rconroy on 5/24/2017.
 */
public class AdderUtilityWithReturnValue implements Callable<Integer> {
    private int leftInt;
    private int rightInt;

    public AdderUtilityWithReturnValue(int leftInt, int rightInt)
    {
        this.leftInt = leftInt;
        this.rightInt = rightInt;
    }

    @Override
    public Integer call() throws IOException {
        return leftInt + rightInt;
    }
}
