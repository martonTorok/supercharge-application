package service;

import model.Account;

import java.util.List;

public class AccountService {

    public List<Account> getAllAccounts() {
        return Account.bankAccounts;
    }

    public Account getAccountById(int accountId) {
        return getAllAccounts().get(accountId);
    }
}
