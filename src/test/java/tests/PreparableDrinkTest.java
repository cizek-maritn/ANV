/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests;

import cizek.anv.cafe.Coffee;
import cizek.anv.cafe.DrinkOrder;
import cizek.anv.cafe.Tea;
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
public class PreparableDrinkTest {
    
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
    void shouldAddAndRemoveDrinks() {
        DrinkOrder order = new DrinkOrder();
        Coffee coffee = new Coffee();

        order.addDrink(coffee);
        assertEquals(1, order.getCount());

        order.removeDrink(coffee);
        assertEquals(0, order.getCount());
    }
    
    @Test
    void orderShouldHaveName() {
        assertNotNull(new DrinkOrder().getName());
    }
    
    @Test
    void orderShouldPreserveOrder() {
        DrinkOrder order = new DrinkOrder();
        Coffee coffee = new Coffee();
        Tea tea = new Tea();

        order.addDrink(coffee);
        order.addDrink(tea);
        
        order.prepare();

        String output = outContent.toString().trim();
        String[] lines = outContent.toString().trim().split("\\R"); // \\R = any line break

        assertArrayEquals(
            new String[]{
                "[APP] Preparing: Drink Order of 2 drinks.",
                "[APP] Starting preparation: Coffee",
                "[APP] Boiling water for drink",
                "[APP] Brewing a fragrant coffee",
                "[APP] Pouring drink",
                "[APP] Done: Coffee",
                "[APP] Starting preparation: Tea",
                "[APP] Boiling water for drink",
                "[APP] Brewing a delicious tea",
                "[APP] Pouring drink",
                "[APP] Done: Tea"
            },
            lines
        );
    }
}
