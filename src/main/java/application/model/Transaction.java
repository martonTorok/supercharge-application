package model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private static int idCounter = 0;
    private int transactionId;
    private TransactionType type;
    private BigDecimal amountOfMoney;
    private int sourceAccountId;
    private int targetAccountId;
    private Date dateTime;

    public Transaction(TransactionType transactionType, BigDecimal amountOfMoney, int sourceAccountId, int targetAccountId) {
        this.type = transactionType;
        this.amountOfMoney = amountOfMoney;
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.transactionId = idCounter++;
        this.dateTime = new Date();
    }

    public TransactionType getType() {
        return type;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }

    public int getSourceAccountId() {
        return sourceAccountId;
    }

    public int getTargetAccountId() {
        return targetAccountId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", amountOfMoney=" + amountOfMoney +
                ", sourceAccountId=" + sourceAccountId +
                ", targetAccountId=" + targetAccountId +
                ", dateTime=" + new SimpleDateFormat("dd-MM-yy:HH:mm:SS Z").format(dateTime) +
                '}';
    }
}
