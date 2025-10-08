/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cizek.anv.cafe;

/**
 *
 * @author DELL
 */
public class CustomDrink{
    private String base;
    private boolean sugar;
    private boolean milk;
    private boolean caramel;
    
    private CustomDrink(Builder b) {
        this.base=b.base;
        this.sugar=b.sugar;
        this.milk=b.milk;
        this.caramel=b.caramel;
    }
    
    @Override
    public String toString() {
        if (base==null) return null;
        return DrinkFactory.createDrink(base).serve()
            + (milk ? ", milk" : "")
            + (sugar ? ", sugar" : "")
            + (caramel ? ", caramel" : "");
    }
    
    public static class Builder {
        private String base;
        private boolean sugar=false;
        private boolean milk=false;
        private boolean caramel=false;
        
        public Builder(String base) {
            this.base=base;
        }
        
        public Builder milk() {
            this.milk=true;
            return this;
        }
        
        public Builder sugar() {
            this.sugar=true;
            return this;
        }
        
        public Builder caramel() {
            this.caramel=true;
            return this;
        }
        
        public CustomDrink build() {
            return new CustomDrink(this);
        }
    }
}
