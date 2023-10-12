package com.herbalife.labs.lab03;

import java.util.stream.IntStream;

public class AccountUser {
    public static void main(String[] args) {
        Account account = new Account(3290473, 100000);
        account.deposit(1000);
        account.deposit(1000);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        System.out.println("Balance %s".formatted(account.getBalance()));
        System.out.println("*****Statement****");
        account.printStatement();
        Account currentAccount = new CurrentAccount(7786876, 1000000);
        currentAccount.deposit(10000);
        currentAccount.deposit(10000);
        //IntStream.range(1, 15)
        for (int i = 0; i < 15; i++) {
            currentAccount.withdraw(10);
        }
        System.out.println("*****Statement****");
        currentAccount.printStatement();
        Account premiumCurrentAccount = new PremiumCurrentAccount(17786876, 10000000);
        premiumCurrentAccount.deposit(10000);
        premiumCurrentAccount.deposit(10000);
        //IntStream.range(1, 15)
        for (int i = 0; i < 150; i++) {
            premiumCurrentAccount.withdraw(10);
        }
        System.out.println("*****Statement****");
        premiumCurrentAccount.printStatement();
    }
}
