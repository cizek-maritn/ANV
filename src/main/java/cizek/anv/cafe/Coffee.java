/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cizek.anv.cafe;

/**
 *
 * @author DELL
 */
public class Coffee extends DrinkTemplate implements Drink {
    @Override
    public String getName() {
        return "Coffee";
    }

    @Override
    protected void brew() {
        System.out.println("[APP] Brewing a fragrant coffee");
    }
}
