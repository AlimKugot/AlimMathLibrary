package alim.math.matrix.util;

import alim.math.matrix.Matrices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static alim.math.matrix.Matrices.*;

public class PrinterMatrixTest {
    OutputStream os = new ByteArrayOutputStream();

    @BeforeEach
    void init() {
        Matrices.initMatrices();
    }


    @Test
    @DisplayName("doesn't expect any exception")
    void print() {
        Assertions.assertDoesNotThrow(() ->
                PrinterMatrix.print(os, matrix3x3, 3, 3));
        Assertions.assertDoesNotThrow(() ->
                PrinterMatrix.print(os, matrix3x3, 2, 2));

        Assertions.assertDoesNotThrow(() ->
                PrinterMatrix.print(os, doubleMatrix3x3, 3, 3));
        Assertions.assertDoesNotThrow(() ->
                PrinterMatrix.print(os, doubleMatrix3x3, 2, 2));
    }

    @Test
    void arrayIndexOfBoundException() {
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> PrinterMatrix.print(os, matrix3x3, 2, 8));

        Assertions.assertDoesNotThrow(() -> PrinterMatrix.print(os, matrix4x5, -1, 22));
    }
}
