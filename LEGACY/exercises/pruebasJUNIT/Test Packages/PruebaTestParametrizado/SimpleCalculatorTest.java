/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package probandojunit;

import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author amezc
 */
@RunWith(value = Parameterized.class)
public class SimpleCalculatorTest {

    @Parameters
    public static Iterable<Object[]> getData() {
        return Arrays.asList(new Object[][]{
            {3, 1, 4}, {2, 3, 5}, {2, 7, 9},
            {1, 9, 10}, {1232, 3, 1235}, {111, 222, 333},
            {6, 11, 17}, {6, 6, 12}, {5, 15, 20}
        });
    }

    private int a, b, resultEsperado;

    public SimpleCalculatorTest(int a, int b, int resultEsperado) {
        this.a = a;
        this.b = b;
        this.resultEsperado = resultEsperado;
    }

    @Test
    public void testAdd() {
        SimpleCalculator calc = new SimpleCalculator();
        int result = calc.add(a, b);
        assertEquals(resultEsperado, result);
    }
}
