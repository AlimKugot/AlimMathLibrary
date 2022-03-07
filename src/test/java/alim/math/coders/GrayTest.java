package alim.math.coders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrayTest {
    private static final int x1 = 154;
    private static final int x2 = 4;
    private static final int x3 = 12;
    private static final int x4 = 343;
    private static final int x5 = -299;


    @Test
    void fromCodeGray() {
        Assertions.assertEquals(236, Gray.encodeGray(x1));
        Assertions.assertEquals(7, Gray.encodeGray(x2));
        Assertions.assertEquals(8, Gray.encodeGray(x3));
        Assertions.assertEquals(410, Gray.encodeGray(x4));
        Assertions.assertEquals(0, Gray.encodeGray(x5));
    }

    @Test
    void fromCodeGrayBinary() {
        Assertions.assertEquals(236, Gray.encodeGray(Integer.toBinaryString(x1)));
        Assertions.assertEquals(7, Gray.encodeGray(Integer.toBinaryString(x2)));
        Assertions.assertEquals(8, Gray.encodeGray(Integer.toBinaryString(x3)));
        Assertions.assertEquals(410, Gray.encodeGray(Integer.toBinaryString(x4)));
        Assertions.assertEquals(0, Gray.encodeGray(Integer.toBinaryString(x5)));
    }

    @Test
    void fromCodeGrayStringBuffer() {
        String expString = "10011010\n" +
                "01001101\n" +
                "00100110\n" +
                "00010011\n" +
                "00001001\n" +
                "00000100\n" +
                "00000010\n" +
                "00000001\n" +
                "--------\n" +
                "11101100\n";

        StringBuffer actual = new StringBuffer();
        actual = Gray.encodeGray(Integer.toBinaryString(x1), actual);
        Assertions.assertEquals(expString, actual.toString());
    }

    @Test
    void fromCodeGrayStringBufferNegative() {
        StringBuffer actual = new StringBuffer();
        actual = Gray.encodeGray(Integer.toBinaryString(x5), actual);
        Assertions.assertEquals("0\n", actual.toString());
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
