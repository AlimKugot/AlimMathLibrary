import alimMath.Numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumbersTest {


    @Test
    void gcd() {
        int a = 12;
        int b = 11;

        // gcd = 16
        int c = 64;
        int d = 48;

        int minusC = -64;
        int minusD = -48;

        Assertions.assertEquals(1, Numbers.gcd(a, b));
        Assertions.assertEquals(16, Numbers.gcd(c, d));
        Assertions.assertEquals(16, Numbers.gcd(minusC, minusD));
    }

    @Test
    void lcm() {
        long a = 408;
        long b = 561;

        long c = 11;
        long d = 7;

        long m = 15;
        long n = 20;

        Assertions.assertEquals(4488, Numbers.lcm(a, b));
        Assertions.assertEquals(77, Numbers.lcm(c, d));
        Assertions.assertEquals(60, Numbers.lcm(m, n));
    }
}