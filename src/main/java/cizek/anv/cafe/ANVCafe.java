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
        
        EmployeeObserver waiter = new EmployeeObserver("Waiter");
        EmployeeObserver barista = new EmployeeObserver("Barista");
        
        OrderSubject order = new OrderSubject();
        order.addObserver(barista);
        order.addObserver(waiter);
        
        CustomDrink cd = new CustomDrink.Builder("coffee").milk().sugar().build();
        //System.out.println(cd);
        String msg = cd + " in " + config.getCafeName();
        //String msg=null;
        
        order.notifyAll(msg);
        
        OrderSubject payment = new OrderSubject();
        payment.addObserver(waiter);
        
        Checkout checkout = new Checkout(new CardPaymentStrategy());
        payment.notifyAll(checkout.processPayment(150, 4));
        checkout.setStrategy(new CashPaymentStrategy());
        payment.notifyAll(checkout.processPayment(100, 2));
    }
}
