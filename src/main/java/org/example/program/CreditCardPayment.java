package org.example.program;

public class CreditCardPayment extends RRPaymentService{

    private String paymentId;
    private double cashBack;
    private double balanceDue;


    public CreditCardPayment(double balance,double balanceDue) {
        super(balance);
        this.balanceDue=balanceDue;
    }

    @Override
    public void payBill(double amount) {
        this.paymentId = "C"+counter++;
        double temp;
        if((cashBack+amount)>balanceDue){
            temp = (cashBack+amount)-balanceDue;
            balance-=temp;
            cashBack=temp;
            balanceDue=0;
        }else {
            temp=balanceDue-(amount+cashBack);
            balance-=temp;
            cashBack=0;
        }
    }

    @Override
    public String toString() {
        return "CreditCardPayment{" +
                "balanceDue=" + balanceDue +
                ", balance=" + balance +
                ", paymentId='" + paymentId + '\'' +
                ", cashBack=" + cashBack +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
