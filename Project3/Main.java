package Project3;

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00);  // starting with $1000
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
