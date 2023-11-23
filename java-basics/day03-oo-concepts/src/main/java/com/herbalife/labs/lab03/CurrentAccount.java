package com.herbalife.labs.lab03;

public class CurrentAccount extends Account {



    public CurrentAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public int getWithdrawLimit() {
        return 10;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > AccountConstants.CURRENT_ACCOUNT_WITHDRAWAL_LIMIT) {
            throw new RuntimeException("Maximum limit for withdrawal is only 100000");
        }
        super.withdraw(amount);
    }
}
