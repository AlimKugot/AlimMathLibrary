import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import alim.math.*;

public class CodersTest {
    int x1 = 154;
    int x2 = 4;
    int x3 = 12;
    int x4 = 343;
    int x5 = -299;


    @Test
    void fromCodeGray() {
        Assertions.assertEquals(236, Coders.encodeGray(x1));
        Assertions.assertEquals(7, Coders.encodeGray(x2));
        Assertions.assertEquals(8, Coders.encodeGray(x3));
        Assertions.assertEquals(410, Coders.encodeGray(x4));
        Assertions.assertEquals(0, Coders.encodeGray(x5));
    }

    @Test
    void toCodeGray() {
        Assertions.assertEquals(215, Coders.codeGray(x1));
        Assertions.assertEquals(6, Coders.codeGray(x2));
        Assertions.assertEquals(10, Coders.codeGray(x3));
        Assertions.assertEquals(508, Coders.codeGray(x4));
        Assertions.assertEquals(0, Coders.codeGray(x5));
    }
}
