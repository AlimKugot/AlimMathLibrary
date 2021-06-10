package alim.math.matrix;

import static alim.math.matrix.util.CopyMatrix.swapRow;

/**
 * From any matrix to triangle matrix
 *
 * @author Alim Kugotov
 */
public class Triangle {

    /**
     * Update matrix to Upper Triangular
     *
     * @param matrix to update to upper triangular
     * @param row    size
     * @param column size
     * @return triangular matrix[row][column]
     */
    public static double[][] toUpperTriangularMatrix(double[][] matrix, int row, int column) {
        for (int j = 0; j < column; j++) {

            //if matrix[i][j] == 0, we can't multiply with zero
            int i = j;
            while (i < row && matrix[i][j] == 0) ++i;
            if (i != j) {
                matrix = swapRow(matrix, row, column, i, j);
                i = j;
            }

            for (int ik = i + 1; ik < row; ik++) {
                if (matrix[ik][j] == 0) continue;

                double toDiv = matrix[i][j] / matrix[ik][j];
                if (toDiv < 1.0) toDiv = matrix[ik][j] / matrix[i][j];

                for (int jk = 0; jk < column; jk++) {
                    matrix[ik][jk] -= toDiv * matrix[i][jk];
                }
            }
        }
        return matrix;
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
    public static int[][] toTriangleInRing(int[][] matrix, int row, int col, final int Z) {
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
        return matrix;
    }
}
