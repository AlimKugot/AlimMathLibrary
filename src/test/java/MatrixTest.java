import alim.math.numbers.Fraction;
import alim.math.*;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class MatrixTest {
    static int[][] matrix3x3;
    static int[][] matrix4x4;
    static int[][] matrix4x5;

    static double[][] doubleMatrix3x3;
    static double[][] doubleMatrix4x5;
    static double[][] doubleMatrix3x3FirstIsZero;

    /**
     * I don't use @BeforeAll, because in some functions we need to change matrices
     */
    @BeforeEach
    void initMatrices() {
        matrix3x3 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        doubleMatrix3x3 = new double[][]{
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };

        doubleMatrix3x3FirstIsZero = new double[][]{
                {0.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };

        matrix4x4 = new int[][]{
                {5, 2, 3, 5},
                {3, 6, 7, 8},
                {2, 8, 1, 3},
                {5, 9, 5, 5}
        };

        matrix4x5 = new int[][]{
                {5, 2, 1, 3, 8},
                {4, 8, 3, 2, 1},
                {23, 8, 9, 5, 4},
                {98, 82, 52, 36, 4}
        };

        doubleMatrix4x5 = new double[][]{
                {5.0, 2.0, 1.0, 3.0, 8.0},
                {4.0, 8.0, 3.0, 2.0, 1.0},
                {23.0, 8.0, 9.0, 5.0, 4.0},
                {98.0, 82.0, 52.0, 36.0, 4.0}
        };
    }


    @Nested
    class Print {

        @Test
        @DisplayName("doesn't expect any exception")
        void print() {
            Assertions.assertDoesNotThrow(() ->
                    Matrix.print(System.out, matrix3x3, 3, 3));
            Assertions.assertDoesNotThrow(() ->
                    Matrix.print(System.out, matrix3x3, 2, 2));

            Assertions.assertDoesNotThrow(() ->
                    Matrix.print(System.out, doubleMatrix3x3, 3, 3));
            Assertions.assertDoesNotThrow(() ->
                    Matrix.print(System.out, doubleMatrix3x3, 2, 2));
        }

        @Test
        void expectIOException() {
//            Matrix.print(System.out, matrix3x3, 2, 8);
        }

        @Test
        void arrayIndexOfBoundException() {
            Assertions.assertThrows(IndexOutOfBoundsException.class,
                    () -> Matrix.print(System.out, matrix3x3, 2, 8));

            Assertions.assertDoesNotThrow(() -> Matrix.print(System.out, matrix4x5, -1, 22));

        }
    }

    @Nested
    class Determinant {

        @Test
        @DisplayName("3x3")
        void determinant3x3() {
            int res3x3 = Matrix.detMatrix(matrix3x3, 3);
            Assertions.assertEquals(0, res3x3);
        }

        @Test
        @DisplayName("4x4")
        void determinant4x4() {
            int res4x4 = Matrix.detMatrix(matrix4x4, 4);
            Assertions.assertEquals(529, res4x4);
        }

        @Test
        @DisplayName("4x5")
        void determinant4x5() {
            Assertions.assertThrows(IndexOutOfBoundsException.class,
                    () -> Matrix.detMatrix(matrix4x5, 5));
        }
    }

    @Nested
    class SwapRow {

        @Test
        @DisplayName("3x3")
        void swapRow3x3() {
            int[][] res = Matrix.swapRow(matrix3x3, 3, 3, 0, 2);
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
            double[][] res = Matrix.swapRow(doubleMatrix4x5, 4, 5, 1, 2);
            Assertions.assertTrue(Arrays.deepEquals(exp, res));
        }

        @Nested
        class Errors {

            @Test
            void logic() {
                int[][] res = Matrix.swapRow(matrix3x3, 3, 3, 1, 1);
                Assertions.assertTrue(Arrays.deepEquals(matrix3x3, res));
            }

            @Test
            void doesntThrowArrayIndexOutOfBoundsException() {
                Assertions.assertDoesNotThrow(
                        () -> Matrix.swapRow(matrix3x3, 1, 5, 2, 3));
                Assertions.assertDoesNotThrow(
                        () -> Matrix.swapRow(matrix3x3, -1, -5, -2, -3));
                Assertions.assertDoesNotThrow(
                        () -> Matrix.swapRow(doubleMatrix3x3, 1, 5, 2, 3));
                Assertions.assertDoesNotThrow(
                        () -> Matrix.swapRow(doubleMatrix3x3, -1, 5, 2, 3));
            }
        }
    }

    @Nested
    class Copy {

        @Test
        @DisplayName("int matrices")
        void copyMatrixInt() {
            int[][] res3x3 = Matrix.copyMatrix(matrix3x3, 3, 3);
            int[][] res4x4 = Matrix.copyMatrix(matrix4x4, 4, 4);
            int[][] res4x5 = Matrix.copyMatrix(matrix4x5, 4, 5);

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
            double[][] res3x3 = Matrix.copyMatrix(doubleMatrix3x3, 3, 3);
            double[][] res4x5 = Matrix.copyMatrix(doubleMatrix4x5, 4, 5);
            double[][] res3x3FirstZero = Matrix.copyMatrix(doubleMatrix3x3FirstIsZero, 3, 3);

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
                Assertions.assertNull(Matrix.copyIntMatrixToDouble(null, 3, 4));
            }

            @DisplayName("4x5")
            @Test
            void copyIntMatrixToDouble4x5() {
                double[][] res4x5 = Matrix.copyIntMatrixToDouble(matrix4x5, 4, 5);
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
                double[][] res3x3 = Matrix.copyIntMatrixToDouble(matrix3x3, 3, 3);
                Assertions.assertNotNull(res3x3);

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        Assertions.assertEquals(doubleMatrix3x3[i][j], res3x3[i][j]);
                    }
                }
            }
        }
    }

    @Nested
    class SlauCramer {

        @Test
        @DisplayName("4x5")
        void slauCramer4x5() {
            List<Fraction> res = Matrix.slauCramer(matrix4x5, 4, 5);
            Assertions.assertNotNull(res);
            Assertions.assertEquals("927 / 481", res.get(0).toString());
            Assertions.assertEquals("589 / 481", res.get(1).toString());
            Assertions.assertEquals("-2841 / 481", res.get(2).toString());
            Assertions.assertEquals("292 / 481", res.get(3).toString());
        }
    }

    @Nested
    class SlauGauss {

        @Test
        @DisplayName("4x5")
        void slauGauss4x5() {
            Matrix.slauGauss(doubleMatrix4x5, 4, 5);
        }
    }

    @Nested
    @DisplayName("To triangle matrix")
    class Triangle {

        @Test
        @DisplayName("3x3")
        void toTriangleMatrix3x3() {
            double[][] exp = {
                    {1.0, 2.0, 3.0},
                    {0.0, -3.0, -6.0},
                    {0.0, 0.0, 0.0}
            };
            double[][] res = Matrix.toUpperTriangularMatrix(doubleMatrix3x3, 3, 3);
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
            double[][] res = Matrix
                    .toUpperTriangularMatrix(doubleMatrix3x3FirstIsZero, 3, 3);

            Assertions.assertTrue(Arrays.deepEquals(exp, res));
        }

        @Test
        void f() {
            Assertions.fail();
            double[][] res = Matrix.toUpperTriangularMatrix(doubleMatrix4x5, 4, 5);
            try {
                Matrix.print(System.out, res, 4, 5);
            } catch (IOException io) {
//
            }
        }
    }


}
