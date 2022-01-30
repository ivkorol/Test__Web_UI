package HW04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTest {
    public static class CalcAreaTest {

        @Test
        void successSquareCalculation() throws Exception {
            Assertions.assertEquals(Triangle.calcArea(3, 4, 5), 6);
            Assertions.assertTrue(Math.abs(Triangle.calcArea(3, 4, 5) - 6) < 0.0001);
            Assertions.assertEquals(6, Triangle.calcArea(3, 4, 5), 0.0002);
        }

        @Test
        void negativeTriangleTest() {
            Assertions.assertThrows(Exception.class, () -> Triangle.calcArea(-3, 4, 5));
            Assertions.assertThrows(Exception.class, () -> Triangle.calcArea(3, -4, 5));
            Assertions.assertThrows(Exception.class, () -> Triangle.calcArea(3, 4, -5));
            Assertions.assertThrows(Exception.class, () -> Triangle.calcArea(0, 4, 5));
            Assertions.assertThrows(Exception.class, () -> Triangle.calcArea(3, 0, 5));
            Assertions.assertThrows(Exception.class, () -> Triangle.calcArea(3, 4, 0));

        }

    }
}




