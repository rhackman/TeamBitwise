package com.frontlineed.teambitwise.activities.activitymodules.AnnotationDemo;

/**
 * Created by rconroy on 5/25/2017.
 */
public class DeprecatedDemo {
    @Deprecated
    public static String DoSomethingAnOldWay()
    {
        return "Call to DoSomethingAnOldWay()";
    }

    public static String DoSomethingANewWay()
    {
        return "Call to DoSomethingANewWay()";
    }
}
