package alim.math.matrix;

import alim.math.matrix.util.CopyMatrix;

/**
 * Determinant of matrices
 *
 * @author Alim Kugotov
 */
public final class Determinant {

    /**
     * Divide matrix via recursion until matrix size != 3
     *
     * @param matrix cube matrix
     * @param size   size of the cube matrix
     * @return determinant of the matrix
     * @throws ArrayIndexOutOfBoundsException if passed not cube matrix
     */
    public static int detMatrix(int[][] matrix, int size) {

        int det = 0;

        if (size == 3) {
            det += detMatrix3x3(matrix);
            return det;
        }

        for (int i = 0; i < size; i++) {
            int[][] submatrixCurrent = CopyMatrix.submatrix(matrix, size, 0, i);
            det += (i % 2 == 0 ? 1 : -1) * matrix[0][i] * detMatrix(submatrixCurrent, size - 1);
        }
        return det;
    }

    /**
     * Copy without last column and change last column with some column.
     * There is helper to find determinant
     *
     * @param matrix       original
     * @param row          size
     * @param column       size
     * @param columnToSwap to swap with last column
     * @return result of the copying (matrix[row][column-1])
     */
    public static int[][] swapRowWithoutLast(int[][] matrix,
                                              int row, int column, int columnToSwap) {
        int[][] s = new int[row][column - 1];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column - 1; j++) {
                if (j == columnToSwap) {
                    s[i][j] = matrix[i][column - 1];
                } else {
                    s[i][j] = matrix[i][j];
                }
            }
        }
        return s;
    }


    /**
     * Find determinant via triangle method
     *
     * @param matrix with 3x3 size
     * @return determinant of the matrix
     */
    private static int detMatrix3x3(int[][] matrix) {
        int a11 = matrix[0][0];
        int a12 = matrix[0][1];
        int a13 = matrix[0][2];

        int a21 = matrix[1][0];
        int a22 = matrix[1][1];
        int a23 = matrix[1][2];

        int a31 = matrix[2][0];
        int a32 = matrix[2][1];
        int a33 = matrix[2][2];

        int fromRight = a11 * a22 * a33 + a12 * a23 * a31 + a13 * a21 * a32;
        int fromLeft = a13 * a22 * a31 + a11 * a23 * a32 + a12 * a21 * a33;
        return fromRight - fromLeft;
    }
}
