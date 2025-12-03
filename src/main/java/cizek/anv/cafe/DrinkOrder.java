/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cizek.anv.cafe;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class DrinkOrder implements PreparableDrink{
    private List<PreparableDrink> order;

    public DrinkOrder() {
        this.order = new ArrayList<PreparableDrink>();
    }
    
    public void addDrink(PreparableDrink p) {
        order.add(p);
    }
    
    public void removeDrink(PreparableDrink p) {
        order.remove(p);
    }
    
    public int getCount() {
        return order.size();
    }
    
    @Override
    public String getName() {
        return "Drink Order";
    }

    @Override
    public void prepare() {
        System.out.println("[APP] Preparing: " + getName() + " of " + getCount() + " drinks.");

        for (PreparableDrink drink : order) {
            drink.prepare();
        }
    }
}
