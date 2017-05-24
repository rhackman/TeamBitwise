package com.frontlineed.teambitwise.activities.activitymodules.ThreadingDemo;

/**
 * Created by rconroy on 5/24/2017.
 */
public class BankAccountWorker implements Runnable {
    private IBankAccount theAccount;

    public BankAccountWorker(IBankAccount account)
    {
        this.theAccount = account;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 10; i++)
        {
            theAccount.makeDeposit(10);
        }
    }
}
