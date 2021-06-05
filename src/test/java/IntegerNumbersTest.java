import alim.math.numbers.IntegerNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerNumbersTest {


    @Test
    void gcd() {
        int a = 12;
        int b = 11;

        // gcd = 16
        int c = 64;
        int d = 48;

        int minusC = -64;
        int minusD = -48;

        Assertions.assertEquals(1, IntegerNumbers.gcd(a, b));
        Assertions.assertEquals(16, IntegerNumbers.gcd(c, d));
        Assertions.assertEquals(16, IntegerNumbers.gcd(minusC, minusD));
    }

    @Test
    void lcm() {
        long a = 408;
        long b = 561;

        long c = 11;
        long d = 7;

        long m = 15;
        long n = 20;

        Assertions.assertEquals(4488, IntegerNumbers.lcm(a, b));
        Assertions.assertEquals(77, IntegerNumbers.lcm(c, d));
        Assertions.assertEquals(60, IntegerNumbers.lcm(m, n));
    }
}