/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cizek.anv.cafe;

/**
 *
 * @author DELL
 */
public class PaymentCommand implements Command{
    private OrderSubject subject;
    private Checkout checkout;
    private double amount;
    private int table;

    public PaymentCommand(OrderSubject subject, Checkout checkout, double amount, int table) {
        this.subject=subject;
        this.checkout=checkout;
        this.amount=amount;
        this.table=table;
    }

    @Override
    public void execute() {
        subject.notifyAll(checkout.processPayment(amount, table));
    }
}
