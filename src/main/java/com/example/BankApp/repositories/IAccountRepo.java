package com.example.BankApp.repositories;

import com.example.BankApp.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepo extends JpaRepository<Account,Long> {
    //Optional<Account> findBySortCodeAndAccountNumber(String sortCode,String accountNumber);

    Optional<Account> findByAccountNumber(String accountNumber);
}
