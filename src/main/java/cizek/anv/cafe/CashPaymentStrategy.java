/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cizek.anv.cafe;

/**
 *
 * @author DELL
 */
public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public String pay(double amount, int table) {
        return "Customer wants to pay " + amount + " using Cash at table " + table;
    }
}
