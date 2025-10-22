/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cizek.anv.cafe;

/**
 *
 * @author DELL
 */
public class ANVCafe {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        CafeConfig config = CafeConfig.getInstance("Smart Cafe");
//        System.out.println(config.getCafeName());
        
        Drink t = DrinkFactory.createDrink("tea");
        System.out.println(t.serve());
        
        Drink c = DrinkFactory.createDrink("coffee");
        System.out.println(c.serve());
        
        OrderSubject order = new OrderSubject();
        order.addObserver(new EmployeeObserver("Barista"));
        order.addObserver(new EmployeeObserver("Waiter"));
        
        CustomDrink cd = new CustomDrink.Builder("coffee").milk().sugar().build();
        //System.out.println(cd);
        String msg = cd + " in " + config.getCafeName();
        //String msg=null;
        
        order.notifyAll(msg);
    }
}
