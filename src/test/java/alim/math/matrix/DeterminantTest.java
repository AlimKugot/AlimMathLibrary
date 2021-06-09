package alim.math.matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("det")
public class DeterminantTest extends Matrices {
    @Test
    @DisplayName("3x3")
    void determinant3x3() {
        int res3x3 = Determinant.detMatrix(matrix3x3, 3);
        Assertions.assertEquals(0, res3x3);
    }

    @Test
    @DisplayName("4x4")
    void determinant4x4() {
        int res4x4 = Determinant.detMatrix(matrix4x4, 4);
        Assertions.assertEquals(529, res4x4);
    }

    @Test
    @DisplayName("4x5")
    void determinant4x5() {
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> Determinant.detMatrix(matrix4x5, 5));
    }
}
