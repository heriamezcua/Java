/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package probandojunit;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author amezc
 */
public class SimpleCalculatorTest {
    
    public SimpleCalculatorTest() {
    }

    @Test
    public void testAdd() {
        System.out.println("add");
        int numberA = 2;
        int numberB = 2;
        SimpleCalculator instance = new SimpleCalculator();
        int expResult = 4;
        int result = instance.add(numberA, numberB);
        assertEquals(expResult, result, 0);
    }
    
}
