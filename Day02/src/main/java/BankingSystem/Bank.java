package BankingSystem;

import java.util.*;

public class Bank {
    private Map<String, BankAccount> accounts = new HashMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public boolean createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, new BankAccount(accountNumber, initialBalance));
        return false;
    }

    public boolean deposit(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            return true;
        }
        return false;
    }

    public boolean requestWithdrawal(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber) && accounts.get(accountNumber).getBalance() >= amount) {
            withdrawalQueue.add(accountNumber);
            return true;
        }
        return false;
    }

    public boolean processWithdrawal() {
        if (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            double amount = 0.0;
            return accounts.get(accountNumber).withdraw(amount);
        }
        return false;
    }

    public Map<String, Double> getSortedAccountsByBalance() {
        TreeMap<String, Double> sortedAccounts = new TreeMap<>(
                Comparator.comparing(accountNumber -> accounts.get(accountNumber).getBalance())
        );

        for (Map.Entry<String, BankAccount> entry : accounts.entrySet()) {
            sortedAccounts.put(entry.getKey(), entry.getValue().getBalance());
        }

        return sortedAccounts;
    }


    public double getBalance(String accountNumber) {
        return accounts.getOrDefault(accountNumber, new BankAccount("", 0)).getBalance();
    }
}

