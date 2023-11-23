package com.herbalife.labs.lab03;

public interface AccountConstants {
    //variables in an interface are IMPLICITLY public, static and final
    //You don't have to inherit an interface to use the variables

    int ACCOUNT_MINIMUM_BALANCE = 10000;
    double ACCOUNT_WITHDRAWAL_FEE = 0.005;
    int CURRENT_ACCOUNT_WITHDRAWAL_LIMIT = 100000;
    int PREMIUM_CURRENT_ACCOUNT_WITHDRAWAL_LIMIT = 1000000;
    String MINIMUM_BALANCE_ERROR_MESSAGE = "Minimum balance should be 10000";
    String INSUFFICIENT_BALANCE_ERROR_MESSAGE = "Insufficient balance. Withdraw denied for $%s";
}
