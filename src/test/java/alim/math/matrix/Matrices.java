package alim.math.matrix;


public class Matrices {
    public static int[][] matrix3x3;
    public static int[][] matrix4x4;
    public static int[][] matrix4x5;

    public static double[][] doubleMatrix3x3;
    public static double[][] doubleMatrix4x5;
    public static double[][] doubleMatrix3x3FirstIsZero;

    /**
     * Init all matrices in this class
     *
     * Don't use @BeforeAll, because in some functions we need to change matrices
     */
    public static void initMatrices() {
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
}
