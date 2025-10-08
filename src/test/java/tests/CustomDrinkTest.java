/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests;

import cizek.anv.cafe.CustomDrink;
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
public class CustomDrinkTest {
    
    @Test
    void testCustomDrinkNotNull() {
        CustomDrink drink = new CustomDrink.Builder("tea").milk().build();
        assertNotNull(drink);
    }
    
    @Test
    void testDefaultValues() {
        CustomDrink drink = new CustomDrink.Builder("tea").build();
        assertEquals(drink.toString(), "Serving Tea", "drink ingredients are written out only if theyre true");
    }
    
    @Test
    void testIngredients() {
        CustomDrink drink = new CustomDrink.Builder("tea").milk().sugar().caramel().build();
        assertEquals(drink.toString(), "Serving Tea, milk, sugar, caramel", "drink ingredients are written out because they are set to true");
    }
    
    @Test
    void testImmutability() {
        CustomDrink.Builder builder = new CustomDrink.Builder("coffee");
        CustomDrink first = builder.milk().build();
        CustomDrink second = builder.sugar().build();

        // first should not magically gain sugar
        assertNotEquals(first.toString(), second.toString());
    }
    
    @Test
    void testNullBase() {
        CustomDrink drink = new CustomDrink.Builder(null).build();
        assertNull(drink.toString());
    }
    
    @Test
    void testIllegalBase() {
        CustomDrink drink = new CustomDrink.Builder("var").milk().build();
        Exception e = assertThrows(IllegalArgumentException.class, () -> {drink.toString();});
    }
}
