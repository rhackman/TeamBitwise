package com.frontlineed.teambitwise.activities.activitymodules.AnnotationDemo;

/**
 * Created by rconroy on 5/25/2017.
 */
public class DeprecatedDemoWorker implements Runnable {
    public void run()
    {
        //The following line should generate a compiler warning complaining that the method is deprecated
        DeprecatedDemo.DoSomethingAnOldWay();
        //The following line should not be flagged by the compiler'
        DeprecatedDemo.DoSomethingANewWay();
    }
}
