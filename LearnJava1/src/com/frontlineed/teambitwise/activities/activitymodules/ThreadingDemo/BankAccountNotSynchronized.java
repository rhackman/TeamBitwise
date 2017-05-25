package com.frontlineed.teambitwise.activities.activitymodules.ThreadingDemo;

/**
 * Created by rconroy on 5/24/2017.
 */
public class BankAccountNotSynchronized implements IBankAccount {
    private int accountBalance;

    public BankAccountNotSynchronized(int initialBalance)
    {
        accountBalance = initialBalance;
    }

    public int getAccountBalance()
    {
        return accountBalance;
    }

    public void makeDeposit(int amountToBeDeposited)
    {
        accountBalance += amountToBeDeposited;
    }
}
