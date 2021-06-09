package alim.math.matrix.slau;

import alim.math.matrix.Matrices;
import alim.math.numbers.Fraction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CramerTest extends Matrices {

    @BeforeEach
    void init() {
        initMatrices();
    }

    @Test
    @DisplayName("4x5")
    void slauCramer4x5() {
        List<Fraction> res = Cramer.slauCramer(Matrices.matrix4x5, 4, 5);
        Assertions.assertNotNull(res);
        Assertions.assertEquals("927 / 481", res.get(0).toString());
        Assertions.assertEquals("589 / 481", res.get(1).toString());
        Assertions.assertEquals("-2841 / 481", res.get(2).toString());
        Assertions.assertEquals("292 / 481", res.get(3).toString());
    }
}
