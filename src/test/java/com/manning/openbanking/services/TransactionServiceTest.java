package com.manning.openbanking.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import com.manning.openbanking.OpenbankingApplication;
import com.manning.openbanking.entities.Transaction;
import com.manning.openbanking.repositories.TransactionRepository;

import jakarta.activation.DataSource;


@SpringBootTest(classes = {OpenbankingApplication.class})
@Testcontainers
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private TransactionRepository transactionRepository;


    @Container
    static MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0")
        .withDatabaseName("open_banking_manning")
        .withUsername("root")
        .withPassword("root");


        @BeforeAll
    public static void setUp() {
        // Asegúrate de que el contenedor está listo y accesible
        System.out.println("MySQL container started at: " + mysqlContainer.getJdbcUrl());
    }

    @Test
    public void testGetTransactions(){

        Integer accountNumber = 123456789;

        List<Transaction> transactions = transactionService.findAllByAccountNumber(accountNumber);

        //assertTrue(transactions.size() >= 3 && transactions.size() <= 5);
        assertTrue(transactions.size() > 1);
        
    }
}
