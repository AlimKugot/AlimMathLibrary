package alimMath;

/**
 * Methods to work with Matrices
 *
 * @author Alim Kugotov
 */

public final class Matrix {

    /**
     * Find solving of linear equation via Cramer method
     *
     * @param matrix with size [row][row + 1]
     * @param row    count of column in matrix
     * @param column count of column in matrix
     */
    static public void slauCramer(int[][] matrix, int row, int column) {

        if (column - row != 1 || row + column < 7) return;

        // Детерминанта, что в знаменателе у всех переменных
        int detAll = detMatrix(matrix, row);

        for (int i = 0; i < row; i++) {
            int[][] varMatrix = swapRowWithoutLast(matrix, row, column, i);
            int detVariable = detMatrix(varMatrix, row);

            //упрощаем результат
            long nod = Numbers.gcd(detVariable, detAll);
            String varName = "x" + (i + 1);
            String result = (detVariable / nod) + "/" + (detAll / nod);

            System.out.println(varName + " = " + result);
        }
    }

    /**
     * Расщипляет матрицы, пока не дойдёт до матрицы размером 3x3
     * Реализация с помощью рекурсии
     *
     * @param matrix - cube matrix
     * @param size   - size of cube matrix
     * @return determinant of matrix
     */
    public static int detMatrix(int[][] matrix, int size) {

        int det = 0;

        if (size == 3) {
            det += detMatrix3x3(matrix);
            return det;
        }

        for (int i = 0; i < size; i++) {
            int[][] submatrixCurrent = submatrix(matrix, size, 0, i);
            det += (i % 2 == 0 ? 1 : -1) * matrix[0][i] * detMatrix(submatrixCurrent, size - 1);
        }
        return det;
    }


    /**
     * Find determinant via triangle method
     *
     * @param matrix with 3x3 size
     * @return determinant of matrix
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

    /**
     * Copy all except some row and column
     *
     * @param matrix       original
     * @param size         size of original matrix
     * @param exceptColumn not copy
     * @param exceptRow    not copy
     * @return result of copying
     */
    public static int[][] submatrix(int[][] matrix, int size, int exceptRow, int exceptColumn) {
        int[][] copy = new int[size - 1][size - 1];

        int subI = 0;
        for (int i = 0; i < size; i++) {
            copy[subI] = new int[size - 1];
            int subJ = 0;

            if (i == exceptRow) continue;

            for (int j = 0; j < size; j++) {
                if (j == exceptColumn) continue;

                copy[subI][subJ] = matrix[i][j];
                subJ++;
            }
            subI++;
        }
        return copy;
    }

    /**
     * Copy without last column and change last column with some column.
     * There is helper to find determinant
     *
     * @param matrix       original
     * @param row          size
     * @param column       size
     * @param columnToSwap to swap with last column
     * @return result of copying (matrix[row][column-1])
     */
    private static int[][] swapRowWithoutLast(int[][] matrix,
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
     * Copy matrix
     *
     * @param matrix original
     * @param row    size
     * @param column size
     * @return result of copying
     */
    public static int[][] copyMatrix(int[][] matrix, int row, int column) {
        int[][] copy = new int[row][column];

        for (int i = 0; i < row; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, column);
        }
        return copy;
    }
}