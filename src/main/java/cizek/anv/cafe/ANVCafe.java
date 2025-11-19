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
        
        EmployeeObserver waiter = new EmployeeObserver("Waiter");
        EmployeeObserver barista = new EmployeeObserver("Barista");
        OrderSubject order = new OrderSubject();
        order.addObserver(barista);
        OrderSubject payment = new OrderSubject();
        payment.addObserver(waiter);
        
        CustomDrink coffee = new CustomDrink.Builder("coffee").milk().sugar().build();
        CustomDrink tea = new CustomDrink.Builder("tea").sugar().build();
        
        CafeConfig config = CafeConfig.getInstance("Smart Cafe");
        String cafeName = config.getCafeName();
        
        Command coffeeOrder = new OrderCommand(order, coffee + " in " + cafeName);
        Command teaOrder = new OrderCommand(order,tea + " in " + cafeName);
        
        coffeeOrder.execute();
        teaOrder.execute();
        
        Checkout checkout = new Checkout(new CardPaymentStrategy());
        Command payByCard = new PaymentCommand(payment,checkout,150,4);
        checkout.setStrategy(new CashPaymentStrategy());
        Command payByCash = new PaymentCommand(payment,checkout,100,2);
        payByCard.execute();
        payByCash.execute();
    }
}
