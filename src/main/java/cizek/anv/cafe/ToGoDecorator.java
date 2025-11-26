/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cizek.anv.cafe;

/**
 *
 * @author DELL
 */
public class ToGoDecorator extends CustomDrinkDecorator{
    public ToGoDecorator(Drink wrapped) {
        super(wrapped);
    }
    
    @Override
    public String serve() {
        String s = super.serve();
        if (s==null) return null;
        else return s + " [to go]";
    }

    @Override
    public String getName() {
        return null;
    }
}
