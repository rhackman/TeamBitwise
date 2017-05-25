package com.frontlineed.teambitwise.activities.activitymodules.ThreadingDemo;

/**
 * Created by rconroy on 5/24/2017.
 * Note that this class has the methods implemented with synchronized as part of the definition
 */
public class BankAccountWithSynchronizedMethods implements IBankAccount {
    private int accountBalance;

    public BankAccountWithSynchronizedMethods(int initialBalance) { accountBalance = initialBalance; }

    public synchronized int getAccountBalance() { return accountBalance; }

    public synchronized void makeDeposit(int amountToBeDeposited)
    {
        accountBalance += amountToBeDeposited;
    }
}
