package Project3;

import java.util.Scanner;

public class ATM {
    
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    deposit();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\nATM MENU");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: $%.2f%n", account.getBalance());
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
}
