/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cizek.anv.cafe;

/**
 *
 * @author DELL
 */
public abstract class DrinkTemplate implements PreparableDrink{
    public final void prepare() {
        System.out.println("[APP] Starting preparation: " + getName());
        boilWater();
        brew();
        pour();
        System.out.println("[APP] Done: "  + getName());
    }
    
    protected void boilWater() {
        System.out.println("[APP] Boiling water for drink");
    }
    
    protected void pour() {
        System.out.println("[APP] Pouring drink");
    }
    
    protected abstract void brew();
    
    @Override
    public abstract String getName();
}
