package org.example;

public class Transaction {
    public enum Type { DEPOSIT, WITHDRAW }
    private Type type;
    private double amount;
    private boolean success;

    public Transaction(Type type, double amount) {
        this.type = type;
        this.amount = amount;
        this.success = false;
    }

    public void apply(BankAccount account) {
        try {
            if (type == Type.DEPOSIT) {
                account.deposit(amount);
            } else {
                account.withdraw(amount);
            }
            success = true;
        } catch (Exception e) {
            success = false;
        }
    }

    public boolean wasSuccessful() {
        return success;
    }
}
