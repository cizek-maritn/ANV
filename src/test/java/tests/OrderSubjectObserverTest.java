/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tests;

import cizek.anv.cafe.EmployeeObserver;
import cizek.anv.cafe.Observer;
import cizek.anv.cafe.OrderSubject;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
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
public class OrderSubjectObserverTest {
    
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
    void testUpdatePrintsMessage() {
        EmployeeObserver observer = new EmployeeObserver("Alice");
        observer.update("Task completed");

        String output = outContent.toString().trim();
        assertEquals("Alice notified: Task completed", output);
    }

    @Test
    void testUpdateDoesNotPrintWhenStatusIsNull() {
        EmployeeObserver observer = new EmployeeObserver("Bob");
        observer.update(null);

        String output = outContent.toString().trim();
        assertTrue(output.isEmpty(), "Expected no output for null status");
    }
    
    @Test
    void testNotifyAll() {
        OrderSubject order = new OrderSubject();
        order.addObserver(new EmployeeObserver("Alice"));
        order.addObserver(new EmployeeObserver("Bob"));
        order.notifyAll("Hello World");
        
        String output = outContent.toString().trim();
        String[] lines = outContent.toString().trim().split("\\R"); // \\R = any line break
        assertArrayEquals(
            new String[]{
                "Alice notified: Hello World",
                "Bob notified: Hello World"
            },
            lines
        );
    }

    @Test
    void testNotifyAllNull() {
        OrderSubject order = new OrderSubject();
        order.addObserver(new EmployeeObserver("Alice"));
        order.addObserver(new EmployeeObserver("Bob"));
        order.notifyAll(null);

        String output = outContent.toString().trim();
        assertTrue(output.isEmpty(), "Expected no output for null status");
    }
    
    @Test
    void testAssignEmployeeObserverName() {
        EmployeeObserver e = new EmployeeObserver("David");
        assertEquals("David", e.getName());
    }
    
    @Test
    void testAssignEmployeeObserverNameNull() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {new EmployeeObserver(null);});
    }
    
    @Test
    void testSingleUpdate() {
        EmployeeObserver e = new EmployeeObserver("David");
        
    }
    
    @Test
    void testAddOrderSubject() {
        OrderSubject order = new OrderSubject();
        EmployeeObserver e = new EmployeeObserver("Alice");
        order.addObserver(e);
        List<Observer> l = order.getSubjects();
        
        assertEquals(1, l.size());
        assertTrue(l.contains(e));
        assertEquals(e, l.get(0));
    }
    
    @Test
    void testAddOrderSubjectNull() {
        OrderSubject order = new OrderSubject();
        Exception e = assertThrows(IllegalArgumentException.class, () -> {order.addObserver(new EmployeeObserver(null));});
    }
    
    @Test
    void testRemoveOrderSubject() {
        OrderSubject order = new OrderSubject();
        EmployeeObserver e = new EmployeeObserver("Alice");
        order.addObserver(e);
        order.removeObserver(e);
        List<Observer> l = order.getSubjects();
        
        assertEquals(0, l.size());
        assertFalse(l.contains(e));
    }
    
    @Test
    void testRemoveOrderSubjectNull() {
        OrderSubject order = new OrderSubject();
        EmployeeObserver e = new EmployeeObserver("Alice");
        order.addObserver(e);
        order.removeObserver(null);
        List<Observer> l = order.getSubjects();
        
        assertEquals(1, l.size());
        assertTrue(l.contains(e));
        assertEquals(e, l.get(0));
    }
}
