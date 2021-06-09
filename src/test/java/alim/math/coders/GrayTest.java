package alim.math.coders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrayTest {
    int x1 = 154;
    int x2 = 4;
    int x3 = 12;
    int x4 = 343;
    int x5 = -299;


    @Test
    void fromCodeGray() {
        Assertions.assertEquals(236, Gray.encodeGray(x1));
        Assertions.assertEquals(7, Gray.encodeGray(x2));
        Assertions.assertEquals(8, Gray.encodeGray(x3));
        Assertions.assertEquals(410, Gray.encodeGray(x4));
        Assertions.assertEquals(0, Gray.encodeGray(x5));
    }

    @Test
    void toCodeGray() {
        Assertions.assertEquals(215, Gray.codeGray(x1));
        Assertions.assertEquals(6, Gray.codeGray(x2));
        Assertions.assertEquals(10, Gray.codeGray(x3));
        Assertions.assertEquals(508, Gray.codeGray(x4));
        Assertions.assertEquals(0, Gray.codeGray(x5));
    }
}
