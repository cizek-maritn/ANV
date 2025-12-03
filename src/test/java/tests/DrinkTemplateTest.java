/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests;

import cizek.anv.cafe.Coffee;
import cizek.anv.cafe.DrinkTemplate;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
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
public class DrinkTemplateTest {
    
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
    void prepareShouldCallStepsInOrder() {
        new Coffee().prepare();
        String output = outContent.toString().trim();
        String[] lines = outContent.toString().trim().split("\\R"); // \\R = any line break

        assertArrayEquals(
            new String[]{
                "[APP] Starting preparation: Coffee",
                "[APP] Boiling water for drink",
                "[APP] Brewing a fragrant coffee",
                "[APP] Pouring drink",
                "[APP] Done: Coffee"
            },
            lines
        );
    }
    
    @Test
    void prepareMethodShouldBeFinal() throws NoSuchMethodException {
        Method m = DrinkTemplate.class.getMethod("prepare");
        assertTrue(Modifier.isFinal(m.getModifiers()));
    }
}
