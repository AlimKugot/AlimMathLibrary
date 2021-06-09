package alim.math.matrix;

import static alim.math.matrix.util.Copy.swapRow;

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
}
