package AlimMath;


public class Numbers {

    /*
        НОД: алгоритм Евклида
    */
    public static long gcd(long a, long b) {
        if (b == 0) return Math.abs(a);

        return gcd(b, a % b);
    }

    /*
        Extended Euclidean algorithm
     */


    /*
        НОК: использует связку с НОД
     */
    public static long lcm(long a, long b) {
        return (a > b) ? (a / gcd(a, b)) * b : (b / gcd(a, b)) * a ;
    }
}
