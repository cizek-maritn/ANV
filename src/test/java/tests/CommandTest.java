/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests;

import cizek.anv.cafe.CardPaymentStrategy;
import cizek.anv.cafe.CashPaymentStrategy;
import cizek.anv.cafe.Checkout;
import cizek.anv.cafe.Command;
import cizek.anv.cafe.CustomDrink;
import cizek.anv.cafe.EmployeeObserver;
import cizek.anv.cafe.OrderCommand;
import cizek.anv.cafe.OrderSubject;
import cizek.anv.cafe.PaymentCommand;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author DELL
 */
public class CommandTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }
    
    @Test
    void testOrderCommand() {
        EmployeeObserver barista = new EmployeeObserver("Barista");
        OrderSubject order = new OrderSubject();
        order.addObserver(barista);
        CustomDrink coffee = new CustomDrink.Builder("coffee").milk().sugar().build();
        Command coffeeOrder = new OrderCommand(order, coffee + ".");
        coffeeOrder.execute();
        
        String output = outContent.toString().trim();
        assertEquals("Barista notified: Ordered Coffee, milk, sugar.", output);
    }
    
    @Test
    void testPaymentCommand() {
        EmployeeObserver barista = new EmployeeObserver("Barista");
        OrderSubject order = new OrderSubject();
        order.addObserver(barista);
        Checkout checkout = new Checkout(new CashPaymentStrategy());
        Command payByCard = new PaymentCommand(order,checkout,150,4);
        payByCard.execute();
        
        String output = outContent.toString().trim();
        assertEquals("Barista notified: Customer wants to pay 150.0 using Cash at table 4", output);
    }
    
    @Test
    void testNullOrder() {
        Command nullOrder = new OrderCommand(null, null);
        Exception e = assertThrows(NullPointerException.class, () -> {nullOrder.execute();});
    }
    
    @Test
    void testNullPayment() {
        Command nullPay = new PaymentCommand(null,null,150,4);
        Exception e = assertThrows(NullPointerException.class, () -> {nullPay.execute();});
    }
}
