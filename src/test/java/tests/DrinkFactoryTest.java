/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests;

import cizek.anv.cafe.Drink;
import cizek.anv.cafe.DrinkFactory;
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
public class DrinkFactoryTest {
    
    @Test
    void testNullDrink() {
        Drink d = DrinkFactory.createDrink(null);
        assertNull(d, "object should be null with a null argument");
    }
    
    @Test
    void testTeaString() {
        Drink d = DrinkFactory.createDrink("TeA");
        assertEquals(d.serve(), "Serving Tea", "object should be a tea drink no matter the capitalization of letters in argument");
    }
    
    @Test
    void testCoffeeString() {
        Drink d = DrinkFactory.createDrink("cOFfeE");
        assertEquals(d.serve(), "Serving Coffee", "object should be a coffee drink no matter the capitalization of letters in argument");
    }
    
    @Test
    void testIllegalDrink() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {DrinkFactory.createDrink("fail");});        
    }
}
