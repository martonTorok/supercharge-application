package service;

import model.Transaction;

import java.util.List;

public class TransactionHistoryPrintService {

    private TransactionHistoryService transactionHistoryService;

    public TransactionHistoryPrintService(TransactionHistoryService transactionHistoryService) {
        this.transactionHistoryService = transactionHistoryService;
    }

    public void printTransactionHistoryBy(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
