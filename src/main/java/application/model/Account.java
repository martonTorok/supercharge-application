package model;

import sun.util.locale.provider.AvailableLanguageTags;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private User user;
    private int id;
    private static int idCounter = 0;
    private BigDecimal balance;
    private List<Transaction> transactionHistory;
    public static List<Account> bankAccounts = new ArrayList<>();

    public Account(User user) {
        this.user = user;
        this.id = idCounter++;
        this.balance = new BigDecimal(0.0000);
        this.transactionHistory = new ArrayList();
        bankAccounts.add(this);
    }

    public List getTransactionHistory() {
        return transactionHistory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
