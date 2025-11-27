package org.example.program;

public abstract class RRPaymentService {
    protected double balance;
    protected String customerId;
    protected static int counter=1000;

    public RRPaymentService(double balance) {
        this.balance = balance;
        this.customerId = "RR"+counter++;
    }

    public abstract void payBill(double amount);

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerId() {
        return customerId;
    }
}
