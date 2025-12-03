/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cizek.anv.cafe;

/**
 *
 * @author DELL
 */
public abstract class CustomDrinkDecorator implements Drink{
    protected final Drink wrapped;
    
    protected CustomDrinkDecorator(Drink wrapped) {
        this.wrapped=wrapped;
    }
    
    @Override
    public String serve() {
        return wrapped.serve();
    }
    
    @Override
    public String getName() {
        return wrapped.getName();
    }
}
