package alim.math.matrix.util;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Printer {


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
}
