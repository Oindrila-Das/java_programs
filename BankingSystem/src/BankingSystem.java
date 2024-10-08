
import java.util.Scanner;
import java.util.HashMap;

class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
    }

    // Get account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Get account holder's name
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // Get balance
    public double getBalance() {
        return balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully!");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

public class BankingSystem {
    private HashMap<String, Account> accounts = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    // Create a new account
    public void createAccount() {
        System.out.println("Enter Account Number:");
        String accountNumber = scanner.nextLine();

        System.out.println("Enter Account Holder Name:");
        String accountHolderName = scanner.nextLine();

        System.out.println("Enter Initial Deposit Amount:");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine();  // Consume the newline

        Account newAccount = new Account(accountNumber, accountHolderName, initialDeposit);
        accounts.put(accountNumber, newAccount);
        System.out.println("Account created successfully!");
    }

    // Deposit into an account
    public void deposit() {
        System.out.println("Enter Account Number:");
        String accountNumber = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Enter Deposit Amount:");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume the newline
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw from an account
    public void withdraw() {
        System.out.println("Enter Account Number:");
        String accountNumber = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Enter Withdraw Amount:");
            double amount = scanner.nextDouble();
            scanner.nextLine();  // Consume the newline
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Check account balance
    public void checkBalance() {
        System.out.println("Enter Account Number:");
        String accountNumber = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Account Holder: " + account.getAccountHolderName());
            System.out.println("Current Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Display menu
    public void displayMenu() {
        int choice;
        do {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.displayMenu();
    }
}
