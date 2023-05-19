package com.example.BankApp.services;


import com.example.BankApp.models.Account;
import com.example.BankApp.repositories.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    IAccountRepo accountRepo;
    public String addAccount(Account account) {
        accountRepo.save(account);
        return "";
    }

    public String getBalance(String accountNumber) {
        Account account = accountRepo.findByAccountNumber(accountNumber).get();
        if(account==null){
            throw new IllegalStateException("ACCOUNT DOES NOT EXIST");
        }

        return account.getBalance().toString();
    }

    public String depositMoney(String accountNumber, Double amount) {

        Account account = accountRepo.findByAccountNumber(accountNumber).get();
        if(account==null){
            throw new IllegalStateException("ACCOUNT DOES NOT EXIST");
        }

        Double balance = account.getBalance();
        balance += amount;

        account.setBalance(balance);

        accountRepo.save(account);

        return "amount deposit successfully  " + account.getBalance();
    }

    public String debitMoney(String accountNumber, Double amount) {
        Account account = accountRepo.findByAccountNumber(accountNumber).get();
        if(account==null){
            throw new IllegalStateException("ACCOUNT DOES NOT EXIST");
        }

        Double balance = account.getBalance();

        balance -= amount;
        if (balance<=10000){
            throw new IllegalStateException("You can't withdraw insufficient balance...");
        }
        account.setBalance(balance);

        accountRepo.save(account);

        return "amount debit successfully  " + account.getBalance();
    }
}
