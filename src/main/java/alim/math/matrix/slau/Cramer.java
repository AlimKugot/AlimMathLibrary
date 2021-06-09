package alim.math.matrix.slau;

import alim.math.matrix.Determinant;
import alim.math.numbers.Fraction;

import java.util.ArrayList;
import java.util.List;

import static alim.math.matrix.Determinant.detMatrix;

public final class Cramer {
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
            int[][] varMatrix = Determinant.swapRowWithoutLast(matrix, row, column, i);
            long detVariable = detMatrix(varMatrix, row);

            res.add(new Fraction(detVariable, detAll));
        }
        return res;
    }
}
