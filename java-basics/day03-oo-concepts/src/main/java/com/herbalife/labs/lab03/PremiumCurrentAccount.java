package com.herbalife.labs.lab03;

public class PremiumCurrentAccount extends Account {

    public PremiumCurrentAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public int getWithdrawLimit() {
        return 100;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > AccountConstants.PREMIUM_CURRENT_ACCOUNT_WITHDRAWAL_LIMIT) {
            throw new RuntimeException("Maximum limit for withdrawal is only 1000000");
        }
        super.withdraw(amount);
    }
}
