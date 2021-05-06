package alimMath;

/**
 * Methods to work with the Number Theory
 *
 * @author Alim Kugotov
 */
public final class Numbers {

    /**
     * Find gcd via Euclidean algorithm
     *
     * @param a - first number
     * @param b - second number
     * @return gcd of a and b
     */
    public static long gcd(long a, long b) {
        if (b == 0) return Math.abs(a);

        return gcd(b, a % b);
    }

    /**
     * Find lcm via using gcd method
     *
     * @param a - first number
     * @param b - second number
     * @return lcm of a and b
     */
    public static long lcm(long a, long b) {
        return (a > b) ? (a / gcd(a, b)) * b : (b / gcd(a, b)) * a;
    }
}
