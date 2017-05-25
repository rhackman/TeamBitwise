package com.frontlineed.teambitwise.activities.activitymodules.ThreadingDemo;

/**
 * Created by rconroy on 5/24/2017.
 */
public class AdderUtilityNoReturn implements Runnable {
    private int leftInt;
    private int rightInt;

    public AdderUtilityNoReturn(int leftInt, int rightInt)
    {
        this.leftInt = leftInt;
        this.rightInt = rightInt;
    }

    @Override
    public void run() {
        System.out.println(String.format("The sum of %s and %s is: %s", leftInt, rightInt, leftInt + rightInt));
    }
}
