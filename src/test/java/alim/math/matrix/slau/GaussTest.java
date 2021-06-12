package alim.math.matrix.slau;

import org.junit.jupiter.api.*;

import static alim.math.matrix.Matrices.doubleMatrix4x5;
import static alim.math.matrix.Matrices.initMatrices;

public class GaussTest {

    @BeforeEach
    void init() {
        initMatrices();
    }

    @Test
    @DisplayName("4x5")
    void slauGauss4x5() {
        Gauss.slauGauss(doubleMatrix4x5, 4, 5);
    }

    @Nested
    class Ring {
        /**
         * This naming is from tasks in the University
         */
        long[][] matrix1;
        long[][] expected1;

        long[][] matrix2;
        long[][] expected2;


        @BeforeEach
        void initRing() {
            matrix1 = new long[][]{
                    {2, 0, 0, 0, 4, 0},
                    {2, 4, 4, 4, 4, 3},
                    {1, 2, 1, 3, 4, 3},
                    {1, 3, 1, 2, 4, 2},
                    {0, 1, 4, 1, 4, 0}
            };

            expected1 = new long[][]{
                    {2, 0, 0, 0, 0, 1},
                    {0, 4, 0, 0, 0, 1},
                    {0, 0, 2, 0, 0, 1},
                    {0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 1, 1}
            };

            matrix2 = new long[][] {
                    {4, 0, 0, 0, 4, 0},
                    {0, 4, 4, 4, 4, 0},
                    {2, 2, 1, 3, 4, 1},
                    {0, 3, 1, 2, 4, 0},
                    {0, 1, 4, 1, 4, 0}
            };

            expected2 = new long[][]{
                    {1, 0, 0, 0, 0, 1},
                    {0, 2, 0, 0, 0, 1},
                    {0, 0, 1, 0, 0, 1},
                    {0, 0, 0, 1, 0, 2},
                    {0, 0, 0, 0, 4, 1}
            };
        }

        @Test
        void test1() {
            long[][] res1 = Gauss.inRing(matrix1, 5, 6, 5);
            Assertions.assertArrayEquals(expected1, res1);
        }

        @Test
        void test2() {
            long[][] res2 = Gauss.inRing(matrix2, 5, 6, 5);
            Assertions.assertArrayEquals(expected2, res2);
        }
    }
}
