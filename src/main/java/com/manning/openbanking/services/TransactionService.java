package com.manning.openbanking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manning.openbanking.entities.Transaction;
import com.manning.openbanking.repositories.TransactionRepository;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    public List<Transaction> findAllByAccountNumber(Integer accountNumber){
        return transactionRepository.findAllByAccountNumber(accountNumber);
    }

}
