package com.example.BankApp.repositories;

import com.example.BankApp.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionRepo extends JpaRepository<Transaction,Long> {
}
