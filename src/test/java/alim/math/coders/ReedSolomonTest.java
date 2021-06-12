package alim.math.coders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReedSolomonTest {
    final static int[] num1 = {2, 2, 1, 1, 0};

    @Test
    void encode() {
        int[] res = ReedSolomon.encode(num1, 5);
        Assertions.assertNotNull(res);
        Assertions.assertEquals(3, res[0]);
        Assertions.assertEquals(4, res[1]);
        Assertions.assertEquals(3, res[2]);
        Assertions.assertEquals(0, res[3]);
        Assertions.assertEquals(1, res[4]);
    }
}
