package org.example.program;

public class ShoppingPayment extends RRPaymentService{

    private String paymentId;

    public ShoppingPayment(double balance) {
        super(balance);
    }

    @Override
    public void payBill(double amount) {
        if(amount>balance) System.out.println("Not enough balance available 😔");
        else {
            this.paymentId="S"+counter++;
            balance=balance-amount;
            System.out.println("Payment successful 🙏🏻. Payment id : "+this.paymentId);
        }
    }

    public String getPaymentId() {
        return paymentId;
    }
}
