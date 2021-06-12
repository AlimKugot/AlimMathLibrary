package alim.math.matrix.util;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PrinterMatrix {


    /**
     * Elegant print into stream
     *
     * @param os to write
     * @param matrix to print
     * @param row size
     * @param column size
     * @throws IOException if os is incorrect
     */
    public static void print(OutputStream os, int[][] matrix, int row, int column) throws IOException {
        if (matrix == null) return;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                String res = String.format("%6d", matrix[i][j]);
                os.write(res.getBytes(StandardCharsets.UTF_8));
            }
            os.write("\n".getBytes(StandardCharsets.UTF_8));
        }
    }


    /**
     * Elegant print into stream
     *
     * @param os to write
     * @param matrix to print
     * @param row size
     * @param column size
     * @throws IOException if os is incorrect
     */
    public static void print(OutputStream os, double[][] matrix, int row, int column) throws IOException {
        if (matrix == null) return;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                String res = String.format("%9.3f", matrix[i][j]);
                os.write(res.getBytes(StandardCharsets.UTF_8));
            }
            os.write("\n".getBytes(StandardCharsets.UTF_8));
        }
    }

    @SuppressWarnings("Duplicates")
    public static String toLatex(int[][] matrix, int row, int col, final String MATRIX_NAME) {
        StringBuilder res = new StringBuilder();

        res.append(MATRIX_NAME).append(" = ");
        res.append("\\begin{pmatrix}");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res.append(matrix[i][j]).append("&");
            }
            res.deleteCharAt(res.length() - 1);
            res.append("\\\\");
        }
        res.append("\\end{pmatrix}");
        return res.toString();
    }

    @SuppressWarnings("Duplicates")
    public static String toLatex(long[][] matrix, int row, int col, final String MATRIX_NAME) {
        StringBuilder res = new StringBuilder();

        res.append(MATRIX_NAME).append(" = ");
        res.append("\\begin{pmatrix}");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res.append(matrix[i][j]).append("&");
            }
            res.deleteCharAt(res.length() - 1);
            res.append("\\\\");
        }
        res.append("\\end{pmatrix}");

        return res.toString();
    }
}
