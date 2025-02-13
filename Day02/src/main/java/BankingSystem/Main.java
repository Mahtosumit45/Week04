package BankingSystem;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        // Sample Accounts
        bank.createAccount("123", 1000);
        bank.createAccount("456", 1500);
        bank.createAccount("789", 500);

        while (true) {
            System.out.println("\n===== Banking System Menu =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Request Withdrawal");
            System.out.println("4. Process Withdrawal");
            System.out.println("5. Display Accounts Sorted by Balance");
            System.out.println("6. Check Balance");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double initialBalance = scanner.nextDouble();
                    bank.createAccount(accNum, initialBalance);
                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String depositAcc = scanner.nextLine();
                    System.out.print("Enter Amount to Deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (bank.deposit(depositAcc, depositAmount)) {
                        System.out.println("Deposit successful!");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String withdrawAcc = scanner.nextLine();
                    System.out.print("Enter Withdrawal Amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (bank.requestWithdrawal(withdrawAcc, withdrawAmount)) {
                        System.out.println("Withdrawal request added to queue.");
                    } else {
                        System.out.println("Insufficient balance or invalid account.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Withdrawal Amount to Process: ");
                    double processAmount = scanner.nextDouble();
                    if (bank.processWithdrawal()) {
                        System.out.println("Withdrawal processed successfully!");
                    } else {
                        System.out.println("No pending withdrawals or insufficient balance.");
                    }
                    break;

                case 5:
                    System.out.println("\nAccounts Sorted by Balance:");
                    Map<String, Double> sortedAccounts = bank.getSortedAccountsByBalance();
                    for (Map.Entry<String, Double> entry : sortedAccounts.entrySet()) {
                        System.out.println("Account: " + entry.getKey() + " | Balance: " + entry.getValue());
                    }
                    break;

                case 6:
                    System.out.print("Enter Account Number: ");
                    String checkAcc = scanner.nextLine();
                    double balance = bank.getBalance(checkAcc);
                    if (balance >= 0) {
                        System.out.println("Current Balance: " + balance);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 7:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1-7.");
            }
        }
    }
}

