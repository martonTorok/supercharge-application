package service;

import model.Account;
import model.Transaction;
import model.TransactionType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionHistoryService {
    private static List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactionsByAccountIdFilterByTypeAndDate(int accountId, TransactionType type, Date date) {
        List<Transaction> transactionList = new ArrayList<>();
        for(Transaction transaction : transactions) {
            if (transaction.getSourceAccountId() == accountId || transaction.getTargetAccountId() == accountId) {
                if (transaction.getType() == type) {
                    if (transaction.getDateTime().compareTo(date) > 0) {
                        transactionList.add(transaction);
                    }
                }
            }
        }
        return transactionList;
    }
}
