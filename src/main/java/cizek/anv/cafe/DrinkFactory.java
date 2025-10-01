/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cizek.anv.cafe;

/**
 *
 * @author DELL
 */
public class DrinkFactory {
    public static Drink createDrink(String drinkType) {
        if (drinkType==null) return null;
        
        switch (drinkType.toLowerCase()) {
            case "tea":
                return new Tea();
            case "coffee":
                return new Coffee();
            default:
                throw new IllegalArgumentException("Unknown drink: " + drinkType);
        }
    }
}
