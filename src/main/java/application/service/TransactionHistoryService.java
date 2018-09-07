package service;

import model.Account;
import model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryService {
    private static List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactionsByAccountId(int accountId) {
        List<Transaction> transactionList = new ArrayList<>();
        for(Transaction transaction : transactions) {
            if (transaction.getSourceAccountId() == accountId || transaction.getTargetAccountId() == accountId) {
                transactionList.add(transaction);
            }
        }
        return transactionList;
    }
}
