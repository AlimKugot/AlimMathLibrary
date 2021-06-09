package alim.math.matrix.util;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static alim.math.matrix.Matrices.*;

public class CopyTest {

    @BeforeEach
    void init() {
        initMatrices();
    }

    @Nested
    class SwapRow {

        @Test
        @DisplayName("3x3")
        void swapRow3x3() {
            int[][] res = Copy.swapRow(matrix3x3, 3, 3, 0, 2);
            int[][] exp = new int[][]{
                    {7, 8, 9},
                    {4, 5, 6},
                    {1, 2, 3}
            };
            Assertions.assertTrue(Arrays.deepEquals(exp, res));
        }

        @Test
        @DisplayName("4x5_double")
        void swapRow4x5() {
            double[][] exp = new double[][]{
                    {5.0, 2.0, 1.0, 3.0, 8.0},
                    {23.0, 8.0, 9.0, 5.0, 4.0},
                    {4.0, 8.0, 3.0, 2.0, 1.0},
                    {98.0, 82.0, 52.0, 36.0, 4.0}
            };
            double[][] res = Copy.swapRow(doubleMatrix4x5, 4, 5, 1, 2);
            Assertions.assertTrue(Arrays.deepEquals(exp, res));
        }

        @Nested
        class Errors {

            @Test
            void logic() {
                int[][] res = Copy.swapRow(matrix3x3, 3, 3, 1, 1);
                Assertions.assertTrue(Arrays.deepEquals(matrix3x3, res));
            }

            @Test
            void doesntThrowArrayIndexOutOfBoundsException() {
                Assertions.assertDoesNotThrow(
                        () -> Copy.swapRow(matrix3x3, 1, 5, 2, 3));
                Assertions.assertDoesNotThrow(
                        () -> Copy.swapRow(matrix3x3, -1, -5, -2, -3));
                Assertions.assertDoesNotThrow(
                        () -> Copy.swapRow(doubleMatrix3x3, 1, 5, 2, 3));
                Assertions.assertDoesNotThrow(
                        () -> Copy.swapRow(doubleMatrix3x3, -1, 5, 2, 3));
            }
        }
    }

    @Nested
    class Copying {

        @Test
        @DisplayName("int matrices")
        void copyMatrixInt() {
            int[][] res3x3 = Copy.copyMatrix(matrix3x3, 3, 3);
            int[][] res4x4 = Copy.copyMatrix(matrix4x4, 4, 4);
            int[][] res4x5 = Copy.copyMatrix(matrix4x5, 4, 5);

            Assertions.assertTrue(Arrays.deepEquals(matrix3x3, res3x3));
            Assertions.assertNotEquals(matrix3x3, res3x3);

            Assertions.assertTrue(Arrays.deepEquals(matrix4x4, res4x4));
            Assertions.assertNotEquals(matrix4x4, res4x4);

            Assertions.assertTrue(Arrays.deepEquals(matrix4x5, res4x5));
            Assertions.assertNotEquals(matrix4x5, res4x5);
        }

        @Test
        @DisplayName("double matrices")
        void copyMatrixDouble() {
            double[][] res3x3 = Copy.copyMatrix(doubleMatrix3x3, 3, 3);
            double[][] res4x5 = Copy.copyMatrix(doubleMatrix4x5, 4, 5);
            double[][] res3x3FirstZero = Copy.copyMatrix(doubleMatrix3x3FirstIsZero, 3, 3);

            Assertions.assertTrue(Arrays.deepEquals(doubleMatrix3x3, res3x3));
            Assertions.assertNotEquals(doubleMatrix3x3, res3x3);

            Assertions.assertTrue(Arrays.deepEquals(doubleMatrix4x5, res4x5));
            Assertions.assertNotEquals(doubleMatrix4x5, res4x5);

            Assertions.assertTrue(Arrays.deepEquals(doubleMatrix3x3FirstIsZero, res3x3FirstZero));
            Assertions.assertNotEquals(doubleMatrix3x3FirstIsZero, res3x3FirstZero);
        }

        @Nested
        @DisplayName("int matrix to double")
        class CopyIntToDouble {

            @DisplayName("null")
            @Test
            void copyIntMatrixToDoubleNull() {
                Assertions.assertNull(Copy.copyIntMatrixToDouble(null, 3, 4));
            }

            @DisplayName("4x5")
            @Test
            void copyIntMatrixToDouble4x5() {
                double[][] res4x5 = Copy.copyIntMatrixToDouble(matrix4x5, 4, 5);
                Assertions.assertNotNull(res4x5);

                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 5; j++) {
                        Assertions.assertEquals(doubleMatrix4x5[i][j], res4x5[i][j]);
                    }
                }
            }

            @DisplayName(("3x3"))
            @Test
            void copyIntMatrixToDouble3x3() {
                double[][] res3x3 = Copy.copyIntMatrixToDouble(matrix3x3, 3, 3);
                Assertions.assertNotNull(res3x3);

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        Assertions.assertEquals(doubleMatrix3x3[i][j], res3x3[i][j]);
                    }
                }
            }
        }
    }
}
