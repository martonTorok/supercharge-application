package model;

import java.math.BigDecimal;

public class Account {
    private User user;
    private int id;
    private static int idCounter = 0;
    private BigDecimal balance;

    public Account(User user) {
        this.user = user;
        this.id = ++idCounter;
        this.balance = new BigDecimal(0.0000);
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

}
