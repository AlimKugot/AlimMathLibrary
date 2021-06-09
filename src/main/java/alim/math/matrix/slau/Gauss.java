package alim.math.matrix.slau;

import alim.math.matrix.Triangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Solve of linear equations
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
}
