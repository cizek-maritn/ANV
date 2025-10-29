/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cizek.anv.cafe;

/**
 *
 * @author DELL
 */
public class Checkout {
    private PaymentStrategy paymentMethod;
    
    public Checkout(PaymentStrategy p) {
        this.paymentMethod=p;
    }
    
    public void setStrategy(PaymentStrategy p) {
        this.paymentMethod=p;
    }
    
    public PaymentStrategy getStrategy() {
        return paymentMethod;
    }
    
    public String processPayment(double amount, int table) {
        if (this.paymentMethod==null) return null;
        return paymentMethod.pay(amount, table);
    }
}
