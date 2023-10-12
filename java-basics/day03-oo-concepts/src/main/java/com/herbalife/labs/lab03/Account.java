package com.herbalife.labs.lab03;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static com.herbalife.labs.lab03.AccountConstants.*;

public class Account {

    private long accountNumber;
    private double balance;
    private int withdrawCount;
    private List<Transaction> transactions;

    public Account(int accountNumber, double balance) {
        if (balance < ACCOUNT_MINIMUM_BALANCE) {
            throw new RuntimeException(MINIMUM_BALANCE_ERROR_MESSAGE);
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public int getWithdrawLimit() {
        return 3;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        this.transactions.add(new Transaction(accountNumber, amount, AccountOperationType.CREDIT, Instant.now().toString()));
    }

    public void withdraw(double amount) {
        if (balance < amount || balance < (balance - amount) || (balance - amount) < ACCOUNT_MINIMUM_BALANCE) {
            throw new RuntimeException(INSUFFICIENT_BALANCE_ERROR_MESSAGE.formatted(amount));
        }
        withdrawCount++;
        balance -= amount;
        this.transactions.add(new Transaction(accountNumber, amount, AccountOperationType.DEBIT, Instant.now().toString()));
        if (withdrawCount > getWithdrawLimit()) {
            double fee = amount * ACCOUNT_WITHDRAWAL_FEE;
            balance -= fee;
            this.transactions.add(new Transaction(accountNumber, fee, AccountOperationType.DEBIT_FEE, Instant.now().toString()));
        }
    }

    public void printStatement() {
        transactions.forEach(txn -> System.out.println("Account number: %s, amount: $%s, type: %s, time: %s".formatted(txn.accountNumber(), txn.amount(), txn.type(), txn.time())));
//        for (Transaction txn : this.transactions) {
//            System.out.println("Account number: %s, amount: $%s, type: %s, time: %s".formatted(txn.accountNumber(), txn.amount(), txn.type(), txn.time()));
//        }
    }
}
