import alimMath.Fraction;
import alimMath.Matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class MatrixTest {
    static int[][] matrix3x3;
    static int[][] matrix4x4;
    static int[][] matrix4x5;

    static {
        matrix3x3 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
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
    }

    @Test
    void determinant() {
        int res3x3 = Matrix.detMatrix(matrix3x3, 3);
        int res4x4 = Matrix.detMatrix(matrix4x4, 4);

        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> Matrix.detMatrix(matrix4x5, 5));
        Assertions.assertEquals(0, res3x3);
        Assertions.assertEquals(529, res4x4);
    }

    @Test
    void slauCramer() {
        List<Fraction> res = Matrix.slauCramer(matrix4x5, 4, 5);
        Assertions.assertNotNull(res);
        Assertions.assertEquals("927 / 481", res.get(0).toString());
        Assertions.assertEquals("589 / 481", res.get(1).toString());
        Assertions.assertEquals("-2841 / 481", res.get(2).toString());
        Assertions.assertEquals("292 / 481", res.get(3).toString());
    }
}
