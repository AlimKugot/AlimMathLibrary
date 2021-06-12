package alim.math.coders;

import alim.math.matrix.slau.Gauss;
import alim.math.matrix.util.PrinterMatrix;
import alim.math.numbers.IntegerNumbers;

import java.util.Arrays;

/**
 * To encode numbers to ReedSolomon code
 */
public final class ReedSolomon {
    public static final String FORMULA_LATEX = "A(x)(d_0 + x) = \\sum_{i=0}^{n} x q_i";

    /**
     * Enter numbers to encode into Reed Solomon code
     *
     * @param numbers to encode
     * @param Z       Ring
     */
    public static int[] encode(int[] numbers, int Z) {
        if (numbers.length < 2 || Z < 2) return null;

        int row = numbers.length;
        int col = row + 1;

        long[][] matrix = numbersToMatrix(numbers);
        return solveMatrix(matrix, row, col, Z);
    }

    /**
     * Enter numbers to encode into Reed Solomon code with beautiful Latex solveMatrix
     *
     * @param numbers to encode
     * @param Z       Ring
     * @param builder to append encoding res
     * @return solveMatrix of encoding in latex with matrices
     */
    public static StringBuilder encodeLatex(int[] numbers, int Z, StringBuilder builder) {
        if (numbers.length < 2 || Z < 2) return null;

        int row = numbers.length;
        int col = row + 1;

        builder.append(Arrays.toString(numbers)).append("\\\\");
        builder.append(FORMULA_LATEX).append("\\\\");

        long[][] matrix = numbersToMatrix(numbers);
        builder.append(PrinterMatrix.toLatex(matrix, row, col, "before"));
        builder.append("\\; \\rightarrow \\; ");
        solveMatrixLatex(matrix, row, col, Z, "after", builder);
        return builder;
    }

    /**
     * Convert array into matrix like in the FORMULA_LATEX
     *
     * @param numbers to convert
     * @return matrix
     */
    private static long[][] numbersToMatrix(int[] numbers) {
        int row = numbers.length;
        int col = numbers.length + 1;

        long[][] matrix = new long[row][col];

        for (int i = 0; i < row; i++) {
            //A(x)*d_0 + x)
            matrix[i][0] = numbers[i];

            //q*x
            for (int j = 1; j < col - 2; j++) {
                matrix[i][j] = -(long) Math.pow(i, (col - 2 - j));
            }

            //q0
            matrix[i][col - 2] = -1;

            //... = - A(x)*x
            matrix[i][col - 1] = (long) (-i) * numbers[i];
        }
        return matrix;
    }

    /**
     * Pass matrix to solve with output in latex
     *
     * @param matrix to solve
     * @param row    size
     * @param col    size + 1
     * @param Z      Ring
     */
    private static void solveMatrixLatex(long[][] matrix,
                                         int row, int col, int Z,
                                         final String MATRIX_NAME,
                                         StringBuilder builder) {

        if (matrix == null || row < 2 || col < 2 || col != row + 1) return;

        Gauss.inRing(matrix, row, col, Z);
        builder.append(PrinterMatrix.toLatex(matrix, row, col, MATRIX_NAME));

        builder.append("\\begin{align}");

        long d = matrix[0][0];
        long u = matrix[0][col - 1];

        u = getU(Z, u, d);
        builder.append("d_0").append("&=").append(u).append("\\\\");

        for (int i = 1; i < row; i++) {
            d = matrix[i][i];
            u = matrix[i][col - 1];

            u = getU(Z, u, d);

            builder.append("q_")
                    .append(row - i - 1)
                    .append("&=")
                    .append(u)
                    .append("\\\\");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append("\\end{align}");
    }


    /**
     * Pass matrix to solve
     *
     * @param matrix to solve
     * @param row    size
     * @param col    size + 1
     * @param Z      Ring
     * @return array with params
     */
    private static int[] solveMatrix(long[][] matrix, int row, int col, int Z) {
        if (matrix == null || row < 2 || col < 2 || col != row + 1) return null;

        Gauss.inRing(matrix, row, col, Z);
        int[] res = new int[row];

        long u = matrix[0][col - 1];
        long d = matrix[0][0];

        u = getU(Z, u, d);
        res[0] = (int) u;

        for (int i = 1; i < row; i++) {
            d = matrix[i][i];
            u = matrix[i][col - 1];

            u = getU(Z, u, d);

            res[i] = (int) u;
        }

        return res;
    }

    /**
     * Divide u / d in ring Z
     *
     * @param Z ring
     * @param u up
     * @param d down
     * @return u / d in Z
     */
    private static long getU(int Z, long u, long d) {
        long gcdUD;

        if (d == 0) {
            u = 0;
        } else {
            gcdUD = IntegerNumbers.gcd(u, d);
            u /= gcdUD;
            d /= gcdUD;

            while (d != 1) {
                u += Z;
                gcdUD = IntegerNumbers.gcd(u, d);
                u /= gcdUD;
                d /= gcdUD;
            }
        }
        return u;
    }
}
