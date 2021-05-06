package printer;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

import java.awt.*;

/**
 * Library to beautiful print in latex
 */
public class Latex {

    /**
     * Save file with the formula in PNG format
     *
     * @param latex string to print in latex format
     */
    public static void printLatex(String latex) {
        TeXFormula formula = new TeXFormula(latex);
        formula.createPNG(TeXConstants.STYLE_DISPLAY, 20, "target/ResultLatex.png", Color.WHITE, Color.BLACK);
    }

    /**
     * Save file in the folder with the formula in PNG format
     *
     * @param latex      string to print in latex format
     * @param folderPath where to save
     */
    public static void printLatex(String latex, String folderPath) {
        TeXFormula formula = new TeXFormula(latex);
        formula.createPNG(TeXConstants.STYLE_DISPLAY, 20, folderPath, Color.WHITE, Color.BLACK);
    }
}
