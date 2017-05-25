package com.frontlineed.teambitwise.activities.activitymodules.ThreadingDemo;

import com.frontlineed.teambitwise.activities.IActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by rconroy on 5/24/2017.
 * The implementation of this class is almost identical to the ConcurrencyIssueActivity class - only difference is that
 * the BankAccount class that we are working with has it's methods marked as synchronized, which makes them thread safe
 */
public class ConcurrencyFixActivity implements IActivity {
    public String title = "Threading - demonstration of the fix for the concurrency issue";
    public String desciption = "Depositing $10, 50 (10 times for 5 seperate threads) times into a bank account with an initial balance of $100 - concurrency fix";

    @Override
    public void run()
    {
        try
        {
            System.out.println(desciption);
            //Create 5 worker instances and throw them onto a ThreadPool
            //We will start the BankAccount off with 100 dollars, and expect that adding $10 50 times would yield an ending balance of $600
            ExecutorService exServ = Executors.newFixedThreadPool(5);
            BankAccountWithSynchronizedMethods theBankAccount = new BankAccountWithSynchronizedMethods(100);
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
