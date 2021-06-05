package alim.math;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import alim.math.numbers.*;

/**
 * Methods to work with Matrices
 *
 * @author Alim Kugotov
 */
public final class Matrix {
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

        matrix = toUpperTriangularMatrix(matrix, row, column);
        List<Double> res = new ArrayList<>(matrix.length);

        //todo: need to write
        for (int i = matrix.length; i > 0; --i) {

        }
        return res;
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
     * Find solving of linear equation via Cramer method
     *
     * @param matrix with size [row][row + 1]
     * @param row    count of the column in matrix
     * @param column count of the column in matrix
     * @return result, need to divide key on value
     */
    public static List<Fraction> slauCramer(int[][] matrix, int row, int column) {
        if (column - row != 1 || row + column < 7) return null;

        List<Fraction> res = new ArrayList<>();

        // det[i] / detAll
        long detAll = detMatrix(matrix, row);

        for (int i = 0; i < row; i++) {
            int[][] varMatrix = swapRowWithoutLast(matrix, row, column, i);
            long detVariable = detMatrix(varMatrix, row);

            res.add(new Fraction(detVariable, detAll));
        }
        return res;
    }

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
            int[][] submatrixCurrent = submatrix(matrix, size, 0, i);
            det += (i % 2 == 0 ? 1 : -1) * matrix[0][i] * detMatrix(submatrixCurrent, size - 1);
        }
        return det;
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
     * Classic print to console
     *
     * @param os to write
     * @param matrix to print
     * @param row size
     * @param column size
     * @throws IOException if os is incorrect
     */
    public static void print(OutputStream os, int[][] matrix, int row, int column) throws IOException {
        if (matrix == null) return;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                String res = String.format("%6d", matrix[i][j]);
                os.write(res.getBytes(StandardCharsets.UTF_8));
            }
            os.write("\n".getBytes(StandardCharsets.UTF_8));
        }
    }

    /**
     * Classic print to console
     *
     * @param os to write
     * @param matrix to print
     * @param row size
     * @param column size
     * @throws IOException if os is incorrect
     */
    public static void print(OutputStream os, double[][] matrix, int row, int column) throws IOException {
        if (matrix == null) return;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                String res = String.format("%9.3f", matrix[i][j]);
                os.write(res.getBytes(StandardCharsets.UTF_8));
            }
            os.write("\n".getBytes(StandardCharsets.UTF_8));
        }
    }
}