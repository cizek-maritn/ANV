/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import cizek.anv.cafe.CafeConfig;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author DELL
 */
public class CafeConfigTest {   
    @BeforeEach
    void resetSingleton() {
        // Reset before every test
        CafeConfig.resetForTests();
    }
    
    @Test
    void testSameInstance() {
        CafeConfig instance1 = CafeConfig.getInstance("foo");
        CafeConfig instance2 = CafeConfig.getInstance("bar");
        assertSame(instance1, instance2, "getInstance should always return the same object");
    }
    
    @Test
    void testCafeNameSet() {
        CafeConfig i1 = CafeConfig.getInstance("foo");
        CafeConfig i2 = CafeConfig.getInstance("bar");
        assertEquals("foo", i2.getCafeName(), "CafeName should be set on first init");
    }
    
    @Test
    void testThreadSafe() throws InterruptedException {
        final CafeConfig[] results = new CafeConfig[2];

        Thread t1 = new Thread(() -> results[0] = CafeConfig.getInstance("CafeA"));
        Thread t2 = new Thread(() -> results[1] = CafeConfig.getInstance("CafeB"));

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        assertSame(results[0], results[1], "Both threads should return the same instance");
        assertEquals("CafeA", results[0].getCafeName(), "The first initialized name should win");
    }
    
    @Test
    void testCafeNameGet() {
        CafeConfig instance = CafeConfig.getInstance("Cafe");
        assertEquals("Cafe", instance.getCafeName());
    }
}
