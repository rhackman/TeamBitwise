package com.frontlineed.teambitwise.activities.activitymodules.ThreadingDemo;

import com.frontlineed.teambitwise.activities.IActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by rconroy on 5/24/2017.
 * Because of a concurrency issue with this code (no sense of synchronization with the threads in the threadpool) the ending balance
 * will be slightly off if this activity is ran enough times to get it to appear.
 * The fix for this will be demonstrated in the ConcurrencyFix activity.
 */
public class ConcurrencyIssueActivity implements IActivity {
    public String title = "Threading - demonstration of a concurrency issue";
    public String desciption = "Depositing $10, 50 (10 times for 5 seperate threads) times into a bank account with an initial balance of $100 - concurrency issue";

    @Override
    public void run()
    {
        try
        {
            System.out.println(desciption);
            //Create 5 worker instances and throw them onto a ThreadPool
            //We will start the BankAccount off with 100 dollars, and expect that adding $10 50 times would yield an ending balance of $600
            ExecutorService exServ = Executors.newFixedThreadPool(5);
            BankAccountNotSynchronized theBankAccount = new BankAccountNotSynchronized(100);
            for (int i = 0; i < 5; i++) {
                BankAccountWorker worker = new BankAccountWorker(theBankAccount);
                exServ.submit(worker);
            }
            exServ.shutdown();
            exServ.awaitTermination(60, TimeUnit.SECONDS);
            System.out.println(String.format("Final balance is: %s", theBankAccount.getAccountBalance()));
        }
        catch (InterruptedException interruptedException)
        {
            System.out.println(String.format("There was an exception calling run() inside ConcurrencyIssueActivity. The error is: %s", interruptedException.getMessage()));
        }
    }
}
