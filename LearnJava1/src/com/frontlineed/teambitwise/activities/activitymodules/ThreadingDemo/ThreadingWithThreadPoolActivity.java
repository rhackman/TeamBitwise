package com.frontlineed.teambitwise.activities.activitymodules.ThreadingDemo;

import com.frontlineed.teambitwise.activities.IActivity;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by rconroy on 5/24/2017.
 * Instead of interacting with the Thread class directly, we can use classes that have abstracted the manual kind of
 * management that comes along with utilizing Threads directly. We can use the concept of a ThreadPool, and push
 * work to be executed in multiple threads into the thread pool and all of the inner details is handled by this pool
 * automatically. Also demonstrated is how to harvest a result from a thread.
 */
public class ThreadingWithThreadPoolActivity implements IActivity {
    public String title = "Threading - with Thread Pool via ExecutorService/Executor classes";
    public String description = "Threading using the ThreadPool provided by ExecutorService/Executor - see source code";

    @Override
    public void run()
    {
        try
        {
            System.out.println(description);
            //Code is pretty much going to be the same, except we will populate the executorservice with work, instead
            //of a standalone Thread array.
            ExecutorService es = Executors.newFixedThreadPool(3);

            //Regular addition:
            for (int i = 0; i < 5; i++) {
                AdderUtilityNoReturn adderUtil = new AdderUtilityNoReturn(i, i + 1);
                es.submit(adderUtil);
            }

            //Submit addition work, but retrieve the result from the thread.
            AdderUtilityWithReturnValue adderWithReturnVal = new AdderUtilityWithReturnValue(3, 2);
            Future<Integer> result = es.submit(adderWithReturnVal);

            System.out.println(String.format("Result from return value: %s", result.get().toString()));

            //Tell the executorservice to not accept any more new work, and to terminate itself upon all work completion
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (ExecutionException executionException)
        {
            System.out.println(String.format("There was an error running the run() method in AdderUtilityWithReturnValue. The error is %s.", executionException.getMessage()));
        }
        catch (InterruptedException interruptedException)
        {
            System.out.println(String.format("There was an error running the run() method in AdderUtilityWithReturnValue. The error is: %s", interruptedException.getMessage()));
        }
    }
}
