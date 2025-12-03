/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests;

import cizek.anv.cafe.CustomDrink;
import cizek.anv.cafe.Drink;
import cizek.anv.cafe.OwnMugDecorator;
import cizek.anv.cafe.ToGoDecorator;
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
public class DecoratorTest {
    
    @Test
    void testToGo() {
        Drink coffee = new CustomDrink.Builder("coffee").milk().sugar().build();
        coffee = new ToGoDecorator(coffee);
        assertEquals("Ordered Coffee, milk, sugar [to go]", coffee.serve());
    }
    
    @Test
    void testOwnMug() {
        Drink coffee = new CustomDrink.Builder("coffee").milk().sugar().build();
        coffee = new OwnMugDecorator(coffee);
        assertEquals("Ordered Coffee, milk, sugar [own mug]", coffee.serve());
    }
    
    @Test
    void testOwnMugToGo() {
        Drink coffee = new CustomDrink.Builder("coffee").milk().sugar().build();
        coffee = new OwnMugDecorator(new ToGoDecorator(coffee));
        assertEquals("Ordered Coffee, milk, sugar [to go] [own mug]", coffee.serve());
    }
    
    @Test
    void testNullBase() {
        Drink coffee = new CustomDrink.Builder(null).milk().sugar().build();
        coffee = new OwnMugDecorator(new ToGoDecorator(coffee));
        assertNull(coffee.serve());
    }
    
    @Test
    void testNullDrink() {
        Drink coffee = new OwnMugDecorator(new ToGoDecorator(null));
        Exception e = assertThrows(NullPointerException.class, () -> {coffee.serve();});
    }
    
    @Test
    void testGetName() {
        Drink coffee = new CustomDrink.Builder("Coffee").milk().sugar().build();
        coffee = new OwnMugDecorator(new ToGoDecorator(coffee));
        assertEquals("Coffee", coffee.getName());
    }
}
