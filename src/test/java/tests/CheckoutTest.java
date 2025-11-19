package tests;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import cizek.anv.cafe.CardPaymentStrategy;
import cizek.anv.cafe.CashPaymentStrategy;
import cizek.anv.cafe.Checkout;
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
public class CheckoutTest {
    
    @Test
    void testCardCheckout() {
        CardPaymentStrategy s = new CardPaymentStrategy();
        Checkout c = new Checkout(s);
        assertEquals("Customer wants to pay 100.0 using Credit Card at table 2", c.processPayment(100, 2));
        assertEquals(s, c.getStrategy());
    }
    
    @Test
    void testCashCheckout() {
        CashPaymentStrategy s = new CashPaymentStrategy();
        Checkout c = new Checkout(s);
        assertEquals("Customer wants to pay 100.0 using Cash at table 2", c.processPayment(100, 2));
        assertEquals(s, c.getStrategy());
    }
    
    @Test
    void testNullCheckout() {
        Checkout c = new Checkout(null);
        assertEquals(null, c.processPayment(100, 2));
        assertEquals(null, c.getStrategy());
    }
    
    @Test
    void testSetStrategy() {
        CashPaymentStrategy sOld = new CashPaymentStrategy();
        CardPaymentStrategy sNew = new CardPaymentStrategy();
        Checkout c = new Checkout(sOld);
        c.setStrategy(sNew);
        assertEquals(sNew, c.getStrategy());
    }
}
