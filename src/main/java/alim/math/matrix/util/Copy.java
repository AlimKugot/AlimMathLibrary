package alim.math.matrix.util;

public class Copy {

    /**
     * Swap two rows
     *
     * @param matrix        [row][col]
     * @param row           size
     * @param col           size
     * @param iFirstToSwap  will swap with second
     * @param iSecondToSwap will swap with first
     * @return result matrix
     */
    public static double[][] swapRow(double[][] matrix, int row, int col, int iFirstToSwap, int iSecondToSwap) {
        if (matrix == null
                || iFirstToSwap == iSecondToSwap
                || iFirstToSwap >= row
                || iSecondToSwap >= row) return matrix;

        for (int j = 0; j < col; j++) {
            double temp = matrix[iFirstToSwap][j];
            matrix[iFirstToSwap][j] = matrix[iSecondToSwap][j];
            matrix[iSecondToSwap][j] = temp;
        }
        return matrix;
    }

    /**
     * Swap two rows
     *
     * @param matrix        [row][col]
     * @param row           size
     * @param col           size
     * @param iFirstToSwap  will swap with second
     * @param iSecondToSwap will swap with first
     * @return result matrix
     */
    public static int[][] swapRow(int[][] matrix, int row, int col, int iFirstToSwap, int iSecondToSwap) {
        if (matrix == null
                || iFirstToSwap == iSecondToSwap
                || iFirstToSwap >= row
                || iSecondToSwap >= row) return matrix;

        for (int j = 0; j < col; j++) {
            int temp = matrix[iFirstToSwap][j];
            matrix[iFirstToSwap][j] = matrix[iSecondToSwap][j];
            matrix[iSecondToSwap][j] = temp;
        }
        return matrix;
    }

    /**
     * Copy matrix
     *
     * @param matrix original
     * @param row    size
     * @param column size
     * @return result of the copying
     */
    public static int[][] copyMatrix(int[][] matrix, int row, int column) {
        int[][] copy = new int[row][column];

        for (int i = 0; i < row; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, column);
        }
        return copy;
    }

    /**
     * Copy matrix
     *
     * @param matrix original
     * @param row    size
     * @param column size
     * @return result of the copying
     */
    public static double[][] copyMatrix(double[][] matrix, int row, int column) {
        double[][] copy = new double[row][column];

        for (int i = 0; i < row; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, column);
        }
        return copy;
    }

    /**
     * Small util to copy int matrix to double matrix.
     * Helps to override a lot of functions(attributes)
     *
     * @param matrix to copy
     * @param row    size
     * @param column size
     * @return result of copying
     */
    public static double[][] copyIntMatrixToDouble(int[][] matrix, int row, int column) {
        if (matrix == null || row < 2 || column < 2) return null;

        double[][] res = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                res[i][j] = matrix[i][j];
            }
        }
        return res;
    }

    /**
     * Copy all except some row and column
     *
     * @param matrix       original
     * @param size         size of original matrix
     * @param exceptColumn not copy
     * @param exceptRow    not copy
     * @return result of the copying
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
}
