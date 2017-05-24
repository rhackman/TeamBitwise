package com.frontlineed.teambitwise.activities.activitymodules.ThreadingDemo;

import com.frontlineed.teambitwise.activities.IActivity;

/**
 * Created by rconroy on 5/24/2017.
 * This activity is to demonstrate utilizing the Thread class directly. In this fashion, we as developers are
 * responsible for the managing of the creation/coordination of the threads.
 * Generally in practice, the Thread class is not directly used, rather all of the details of creation of the
 * threads/coordination is abstracted away with the use of thread pool queuing. This will be demonstrated in the
 * ThreadingWithThreadPoolActivity activity.
 */
public class DirectThreadingActivity implements IActivity {
    public String title = "Threading - Direct Use";
    public String description = "Threading using the Thread class directly - see source code";

    @Override
    public void run()
    {
        try {
            System.out.println(description);
            Thread[] threads = new Thread[5];
            for (int i = 0; i < 5; i++) {
                AdderUtilityNoReturn adderUtil = new AdderUtilityNoReturn(i, i + 1);
                threads[i] = new Thread(adderUtil);
                threads[i].start();
            }

            for (Thread theThread : threads) {
                theThread.join(); //Should create blocking calls for threads to finish execution
            }
        }
        catch (InterruptedException e)
        {
            System.out.println(String.format("There was an error running the run() method in AdderUtilityNoReturn. The error is: %s", e.getMessage()));
        }
    }
}
