import alimMath.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


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
    }

    @Test
    void determinant() {
        int res = Matrix.detMatrix(matrix4x4, 4);
        int res3x3 = Matrix.detMatrix(matrix3x3, 3);

        Assertions.assertEquals(0, res3x3);
        Assertions.assertEquals(529, res);
    }

    @Test
    void slauCramer() {

    }
}
