package alim.math.matrix;

import alim.math.matrix.util.Printer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static alim.math.matrix.Matrices.*;

@DisplayName("To triangle matrix")
public class TriangleTest {

    @BeforeEach
    void init() {
        initMatrices();
    }

    @Test
    @DisplayName("3x3")
    void toTriangleMatrix3x3() {
        double[][] exp = {
                {1.0, 2.0, 3.0},
                {0.0, -3.0, -6.0},
                {0.0, 0.0, 0.0}
        };
        double[][] res = Triangle.toUpperTriangularMatrix(doubleMatrix3x3, 3, 3);
        Assertions.assertTrue(Arrays.deepEquals(exp, res));
    }

    @Test
    @DisplayName("3x3 first is zero")
    void toTriangleMatrix3x3FirstIsZero() {
        double[][] exp = {
                {4.0, 5.0, 6.0},
                {0.0, 2.0, 3.0},
                {0.0, 0.0, -0.375}
        };
        double[][] res = Triangle.toUpperTriangularMatrix(doubleMatrix3x3FirstIsZero, 3, 3);

        Assertions.assertTrue(Arrays.deepEquals(exp, res));
    }

//    @Test
//    void f() {
//        todo: it doesn't work
//        double[][] res = Triangle.toUpperTriangularMatrix(doubleMatrix4x5, 4, 5);
//        try {
//            Printer.print(System.out, res, 4, 5);
//        } catch (IOException io) {
//
//        }
//    }
}
