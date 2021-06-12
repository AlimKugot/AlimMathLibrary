package printer;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

import java.awt.*;

/**
 * Library to beautiful print in the latex
 */
public class Latex {
//    final static String author = "\\\\ \\\\ by \\@AlimKugot";
    final static String author = "\\\\ \\\\ by \\ AlimKugot";

    public static final String DEFAULT_FOLDER_TO_SAVE = "target/ResultLatex.png";

    /**
     * Save file with the formula via PNG format
     *
     * @param latex string to print in the latex format
     */
    public static void printLatex(String latex) {
        TeXFormula formula = new TeXFormula(latex + author);
        formula.createPNG(TeXConstants.STYLE_DISPLAY, 20, DEFAULT_FOLDER_TO_SAVE, Color.WHITE, Color.BLACK);
    }

    /**
     * Save file in the folder with the formula via PNG format
     *
     * @param latex      string to print in the latex format
     * @param folderPath where to save
     */
    public static void printLatex(String latex, String folderPath) {
        TeXFormula formula = new TeXFormula(latex);
        formula.createPNG(TeXConstants.STYLE_DISPLAY, 20, folderPath, Color.WHITE, Color.BLACK);
    }
}
