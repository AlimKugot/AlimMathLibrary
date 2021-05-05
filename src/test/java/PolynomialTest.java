import alimMath.Polynomial;
import printer.Latex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PolynomialTest {
    static Map<Double, Double> p1 = new TreeMap<>();
    static Map<Double, Double> p2 = new TreeMap<>();
    static Map<Double, Double> p3 = new TreeMap<>();
    static Map<Double, Double> p4 = new TreeMap<>();

    /*
        initialize variables
     */
    static {
        // (x^5 - 2x^3 - x^2)
        p1.put(5.0, 1.0);
        p1.put(3.0, -2.0);
        p1.put(2.0, -1.0);

        // (3x^4 - 6x^2 - 3x)
        p2.put(4.0, 3.0);
        p2.put(2.0, -6.0);
        p2.put(1.0, -3.0);

        // (x^3 - 2x - 1)
        p3.put(3.0, 1.0);
        p3.put(1.0, -2.0);
        p3.put(0.0, -1.0);

        // (x^0+1x+x^2)
        p4.put(0.0, 1.0);
        p4.put(1.0, 1.0);
        p4.put(2.0, 1.0);
    }

    public static void main(String[] args) {
        List<Double> x = Arrays.asList( 1.0,    -5.0,    -3.0,   -2.0,   -1.0);
        List<Double> y = Arrays.asList(10.0,	40.0,   -34.0,	-11.0,	  4.0);

        Map<Double, Double> res = Polynomial.findPolynomialByPoints(x, y);
        Latex.printLatex(Polynomial.toString(res));
    }

    @Test
    void multiply() {
        Map<Double, Double> p = Polynomial.multiply(p2, p3);

        //pow
        Assertions.assertTrue(p.containsKey(7.0));
        Assertions.assertTrue(p.containsKey(5.0));
        Assertions.assertTrue(p.containsKey(4.0));
        Assertions.assertTrue(p.containsKey(3.0));
        Assertions.assertTrue(p.containsKey(2.0));
        Assertions.assertTrue(p.containsKey(1.0));

        Assertions.assertFalse(p.containsKey(6.0));
        Assertions.assertFalse(p.containsKey(0.0));

        //coefficient
        Assertions.assertEquals(3.0, p.get(7.0));
        Assertions.assertEquals(-12.0, p.get(5.0));
        Assertions.assertEquals(-6.0, p.get(4.0));
        Assertions.assertEquals(12.0, p.get(3.0));
        Assertions.assertEquals(12.0, p.get(2.0));
        Assertions.assertEquals(3.0, p.get(1.0));
    }

    @Test
    void multiplyNum() {
        Map<Double, Double> map = new HashMap<>();
        // 3(x^2+2x-11)
        map.put(2.0, 1.0);
        map.put(1.0, 2.0);
        map.put(0.0, -11.0);

        Polynomial.multiply(map, 3.0);

        Assertions.assertEquals(3, map.size());

        Assertions.assertEquals(3.0, map.get(2.0));
        Assertions.assertEquals(6.0, map.get(1.0));
        Assertions.assertEquals(-33.0, map.get(0.0));

    }

    @Test
    void multiplyListMap() {
        //(x-1)
        Map<Double, Double> polynomial1 = new HashMap<>();
        polynomial1.put(1.0, 1.0);
        polynomial1.put(0.0, -1.0);

        //(x-1)
        Map<Double, Double> polynomial2 = new HashMap<>();
        polynomial2.put(1.0, 1.0);
        polynomial2.put(0.0, -1.0);

        //(x-1)
        Map<Double, Double> polynomial3 = new HashMap<>();
        polynomial3.put(1.0, 1.0);
        polynomial3.put(0.0, -1.0);

        //(x-1)(x-1)(x-1)
        List<Map<Double, Double>> mapList = new ArrayList<>();
        mapList.add(polynomial1);
        mapList.add(polynomial2);
        mapList.add(polynomial3);

        Map<Double, Double> res = Polynomial.multiply(mapList);

        // we must have: (x-1)^3 = x^3 - 3x^2 + 3x - 1
        Assertions.assertEquals(1.0, res.get(3.0));
        Assertions.assertEquals(-3.0, res.get(2.0));
        Assertions.assertEquals(3.0, res.get(1.0));
        Assertions.assertEquals(-1.0, res.get(0.0));
    }

    @Test
    void sum() {
        List<Map<Double, Double>> testV = new ArrayList<>();
        testV.add(p1);
        testV.add(p2);
        testV.add(p3);

        Map<Double, Double> p = Polynomial.sum(testV);
        //  check if result:
        //  x^5 + 3x^4 - x^3 - 7x^2 - 5x - 1
        Assertions.assertEquals(1.0, p.get(5.0));
        Assertions.assertEquals(3.0, p.get(4.0));
        Assertions.assertEquals(-1.0, p.get(3.0));
        Assertions.assertEquals(-7.0, p.get(2.0));
        Assertions.assertEquals(-5.0, p.get(1.0));
        Assertions.assertEquals(-1.0, p.get(0.0));

        Latex.printLatex(Polynomial.toString(p));
    }

    @Test
    void createPolynomial() {
        List<Double> x = Arrays.asList(1.0, 2.0, -3.0);
        List<Map<Double, Double>> mapList = Polynomial.createPolynomial(x);

        Assertions.assertEquals(3, mapList.size());

        Assertions.assertEquals(-1.0, mapList.get(0).get(0.0));
        Assertions.assertEquals(-2.0, mapList.get(1).get(0.0));
        Assertions.assertEquals( 3.0, mapList.get(2).get(0.0));
    }

    /*
            toString p4 : (x^0+1x+x^2) like 1+x+x^2
         */
    @Test
    void print() {
        String expResult = "f(x) = 1+x+x^2";
        Assertions.assertEquals(expResult, Polynomial.toString(p4));

        Latex.printLatex(Polynomial.toString(p4));
    }

    //todo: write normal tests for latex
//    @Test
//    void printLatex() {
//        Polynomial.printLatex("hi", "target/testHI.png");
//    }
}