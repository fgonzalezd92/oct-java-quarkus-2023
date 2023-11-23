package com.herbalife.service;

import com.herbalife.dto.AccountTransactionDto;
import com.herbalife.entity.Account;
import com.herbalife.entity.AccountTransaction;
import com.herbalife.exception.AccountNotFoundException;
import com.herbalife.exception.InsufficientBalanceException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BankService {
    @Transactional
    public void deposit(String accountNumber, int amount, String type) {
        Optional<Account> optionalAccount = Account.find("accountNumber", accountNumber).firstResultOptional();
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setBalance(account.getBalance() + amount);
            account.persist();
            createAccountTransaction(accountNumber, amount, type);
        } else {
            throw new AccountNotFoundException(accountNumber);
        }
    }

    private void createAccountTransaction(String accountNumber, int amount, String type) {
        AccountTransaction accountTransaction = new AccountTransaction();
        accountTransaction.setAccountNumber(accountNumber);
        accountTransaction.setAmount(amount);
        accountTransaction.setTransactionType(type);
        accountTransaction.persist();
    }

    @Transactional
    public void withdraw(String accountNumber, int amount, String type) {
        Optional<Account> optionalAccount = Account.find("accountNumber", accountNumber).firstResultOptional();
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            if (account.getBalance() < amount) {
                throw new InsufficientBalanceException(accountNumber);
            }
            account.setBalance(account.getBalance() - amount);
            account.persist();
            createAccountTransaction(accountNumber, amount, type);
        } else {
            throw new AccountNotFoundException(accountNumber);
        }
    }

    public List<AccountTransactionDto> statement(String accountNumber) {
        Optional<Account> optionalAccount = Account.find("accountNumber", accountNumber).firstResultOptional();
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            return account
                    .getTransactions()
                    .stream()
                    .map(accountTransaction -> new AccountTransactionDto(accountTransaction.getAccountNumber(), accountTransaction.getTransactionType(), accountTransaction.getAmount()))
                    .toList();
        } else {
            throw new AccountNotFoundException(accountNumber);
        }
    }
}
