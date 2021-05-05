import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import AlimMath.ByteAlgorithm;

public class ByteAlgorithmTest {
    int x1 = 154;
    int x2 = 4;
    int x3 = 12;
    int x4 = 343;
    int x5 = -299;


    @Test
    void fromCodeGray() {
        Assertions.assertEquals(236, ByteAlgorithm.fromCodeGray(x1));
        Assertions.assertEquals(7, ByteAlgorithm.fromCodeGray(x2));
        Assertions.assertEquals(8, ByteAlgorithm.fromCodeGray(x3));
        Assertions.assertEquals(410, ByteAlgorithm.fromCodeGray(x4));
        Assertions.assertEquals(0, ByteAlgorithm.fromCodeGray(x5));
    }

    @Test
    void toCodeGray() {
        Assertions.assertEquals(215, ByteAlgorithm.toCodeGray(x1));
        Assertions.assertEquals(6, ByteAlgorithm.toCodeGray(x2));
        Assertions.assertEquals(10, ByteAlgorithm.toCodeGray(x3));
        Assertions.assertEquals(508, ByteAlgorithm.toCodeGray(x4));
        Assertions.assertEquals(0, ByteAlgorithm.toCodeGray(x5));
    }
}
