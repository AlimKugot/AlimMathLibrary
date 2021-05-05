package printer;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

import java.awt.*;

public class Latex {

    /*
        Выдаёт файл с формулой через LaTex в PNG формате
     */
    public static void printLatex(String latex) {
        TeXFormula formula = new TeXFormula(latex);
        formula.createPNG(TeXConstants.STYLE_DISPLAY, 20, "target/ResultLatex.png", Color.WHITE, Color.BLACK);
    }

    public static void printLatex(String latex, String folderPath) {
        TeXFormula formula = new TeXFormula(latex);
        formula.createPNG(TeXConstants.STYLE_DISPLAY, 20, folderPath, Color.WHITE, Color.BLACK);
    }
}
