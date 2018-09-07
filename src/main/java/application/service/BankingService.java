package service;

import model.Account;
import model.Transaction;
import model.TransactionType;

import java.math.BigDecimal;

public class BankingService {

    private TransactionHistoryService transactionHistoryService;
    private AccountService accountService;

    public BankingService(TransactionHistoryService transactionHistoryService, AccountService accountService) {
        this.transactionHistoryService = transactionHistoryService;
        this.accountService = accountService;
    }

    public void deposit(int accountId, BigDecimal amount) {
        validateAmountInput(amount);
        Account selectedAccount = accountService.getAccountById(accountId);
        Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount, accountId, accountId);
        transactionHistoryService.addTransaction(transaction);
        BigDecimal currentBalance = selectedAccount.getBalance();
        selectedAccount.setBalance(currentBalance.add(amount));
    }

    public void withdrawal(int accountId, BigDecimal amount) {
        validateAmountInput(amount);
        Account selectedAccount = accountService.getAccountById(accountId);
        validateBalance(selectedAccount, amount);
        Transaction transaction = new Transaction(TransactionType.WITHDRAWAL, amount, accountId, accountId);
        transactionHistoryService.addTransaction(transaction);
        BigDecimal currentBalance = selectedAccount.getBalance();
        selectedAccount.setBalance(currentBalance.subtract(amount));
    }

    public void transfer(int sourceAccountId, int targetAccountId, BigDecimal amount) {
        withdrawal(sourceAccountId, amount);
        deposit(targetAccountId, amount);
        Transaction transaction = new Transaction(TransactionType.TRANSFER, amount, sourceAccountId, targetAccountId);
        transactionHistoryService.addTransaction(transaction);
    }

    private void validateAmountInput(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount can not be null");
        }
    }

    private void validateBalance(Account account, BigDecimal amount) {
        BigDecimal currentBalance = account.getBalance();
        if (currentBalance.subtract(amount).compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Withdrawal amount is bigger than current Balance amount");
        }
    }
}
