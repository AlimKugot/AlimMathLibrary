package alim.math.matrix.slau;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static alim.math.matrix.Matrices.doubleMatrix4x5;
import static alim.math.matrix.Matrices.initMatrices;

public class GaussTest {

    @BeforeEach
    void init() {
        initMatrices();
    }

    @Test
    @DisplayName("4x5")
    void slauGauss4x5() {
        Gauss.slauGauss(doubleMatrix4x5, 4, 5);
    }
}
