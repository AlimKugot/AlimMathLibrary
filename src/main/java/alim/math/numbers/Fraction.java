package alim.math.numbers;

/**
 * Structure to hold fractions with simplifying
 *
 * @author Alim Kugotov
 */
public final class Fraction {
    private final Long nominator;
    private final Long denominator;


    /**
     * Create Fraction and simplify it (with nod and abs)
     *
     * @param nominator   up
     * @param denominator under
     */
    public Fraction(Long nominator, Long denominator) {
        long gcd = IntegerNumbers.gcd(nominator, denominator);
        if (nominator < 0 && denominator < 0) {
            nominator = Math.abs(nominator);
            denominator = Math.abs(denominator);
        }

        this.nominator = nominator / gcd;
        this.denominator = denominator / gcd;
    }

    public Long getNominator() {
        return nominator;
    }

    public Long getDenominator() {
        return denominator;
    }

    /**
     * @return string like a "1 / 2"
     */
    @Override
    public String toString() {
        return nominator + " / " + denominator;
    }
}
