package com.example.BankApp.controllers;


import com.example.BankApp.models.Account;
import com.example.BankApp.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/account")
    public String addAccount(@RequestBody Account account){
        return accountService.addAccount(account);
    }

    @GetMapping("/{accountNumber}")
    public String getBalance(@PathVariable String accountNumber){
        return accountService.getBalance(accountNumber);
    }
    @PutMapping("/deposit")
    public String depositMoney(@RequestParam("accountNumber") String accountNumber,@RequestParam("amount") Double amount){
        return accountService.depositMoney(accountNumber,amount);
    }

    @PutMapping("/debit")
    public String debitMoney(@RequestParam("accountNumber") String accountNumber,@RequestParam("amount") Double amount){
        return accountService.debitMoney(accountNumber,amount);
    }
}
