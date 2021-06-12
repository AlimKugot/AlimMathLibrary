package alim.math.matrix.slau;

import alim.math.matrix.Triangle;
import alim.math.numbers.IntegerNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Solve linear equations
 *
 * @author Alim Kugotov
 */
public final class Gauss {

    /**
     * Find solving of linear equation via Gauss method
     *
     * @param matrix with size [row][row + 1]
     * @param row    count of the column in matrix
     * @param column count of the column in matrix
     * @return result in double
     */
    public static List<Double> slauGauss(double[][] matrix, int row, int column) {
        if (column - row != 1 || row + column < 7) return null;

        matrix = Triangle.toUpperTriangularMatrix(matrix, row, column);
        List<Double> res = new ArrayList<>(matrix.length);

        //todo: need to write
        for (int i = matrix.length; i > 0; --i) {

        }
        return res;
    }


    /**
     * Worst algorithm but it works
     *
     * @param matrix original
     * @param row size
     * @param col size
     * @param Z residue ring
     * @return triangle matrix in Z
     */
    public static long[][] inRing(long[][] matrix, int row, int col, final int Z) {
        boolean isAgain;
        for (int m = 0; m < col - 1; m++) {
            int n = 0;

            boolean isFindN = true;
            do {
                while (n < row && matrix[n][m] == 0) n++;

                int j;
                for (j = 1; m - j >= 0; j++) {
                    if (matrix[n][m-j] != 0) {
                        n++;
                        isFindN = false;
                        break;
                    }
                }
                if (m - j == -1) isFindN = true;
            } while (!isFindN);

            matrix[n][m] %= Z;
            if (matrix[n][m] < 0) {
                matrix[n][m] += Z;
            }

            do {
                for (int i = 0; i < row; i++) {

                    if (i == n) continue;

                    matrix[i][m] %= Z;
                    if (matrix[i][m] < 0) {
                        matrix[i][m] += Z;
                    }

                    if (matrix[i][m] != 0) {
                        //отними строку
                        for (int j = m; j < col; j++) {
                            matrix[i][j] -= matrix[n][j];
                        }
                    }
                }

                isAgain = false;
                for (int i = 0; i < row; i++) {
                    if (i != n && matrix[i][m] != 0) {
                        isAgain = true;
                        break;
                    }
                }
            } while (isAgain);

        }

        //changes result in the right corner
        for (int i = 0; i < row; i++) {
            matrix[i][col-1] %= Z;
            if (matrix[i][col-1] < 0) matrix[i][col-1] += Z;
        }
        return simplify(matrix, row, col);
    }

    private static long[][] simplify(long[][] matrix, int row, int col) {
        if (matrix == null || col != row + 1) return matrix;

        for (int i = 0; i < row; i++) {
            long gcdFirstLast = IntegerNumbers.gcd(matrix[i][i], matrix[i][col-1]);
            matrix[i][i] /= gcdFirstLast;
            matrix[i][col-1] /= gcdFirstLast;
        }

        return matrix;
    }
}
