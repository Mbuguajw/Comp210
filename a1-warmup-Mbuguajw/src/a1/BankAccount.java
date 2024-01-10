package a1;

public class BankAccount {
    private double balance;

    public BankAccount() {
        balance = 0.0;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }
        balance += amount;
    }

    public synchronized void withdraw(double amount) {
        if (balance < amount || amount < 0) {
            throw new IllegalArgumentException();
        }
        balance -= amount;
    }
}
