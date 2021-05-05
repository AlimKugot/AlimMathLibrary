package alimMath;

import java.text.DecimalFormat;
import java.util.*;
import java.util.List;

public class Polynomial {

    public static Map<Double, Double> findPolynomialByPoints(List<Double> x, List<Double> fx) {
        int size = x.size();

        List<Map<Double, Double>> maps = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {

            List<Double> xCopy = copy(x, i);
            //works with coefficients
            double under = 1.0;
            for (int j = 0; j < size; j++) {
                if (j != i) {
                    under *= (x.get(i) - x.get(j));
                }
            }
            double coefficient = fx.get(i) / under;

            Map<Double, Double> polynomial = multiply(createPolynomial(xCopy));
            maps.add(multiply(polynomial, coefficient));
        }
        return sum(maps);
    }

    private static List<Double> copy(List<Double> list, int exceptIndex) {
        List<Double> res = new ArrayList<>(list.size() - 1);
        for (int i = 0; i < list.size(); i++) {
            if (i != exceptIndex) {
                res.add(list.get(i));
            }
        }
        return res;
    }

    public static List<Map<Double, Double>> createPolynomial(List<Double> x) {
        List<Map<Double, Double>> mapList = new ArrayList<>();

        for (Double c : x) {
            Map<Double, Double> temp = new TreeMap<>();

            //put x : (x - c)
            temp.put(1.0, 1.0);
            //put c : (x - c)
            temp.put(0.0, -c);

            mapList.add(temp);
        }
        return mapList;
    }

    /*
     * Раскроем скобки:
     * (x^2+3x+1)(x^3-2x-1)
     * x^2(x^3-2x-1) + 3x(x^3-2x-1) + 1(x^3-2x-1)
     * Функция выполняет умножения, затем передаёт результат в ф-цию sum(...), чтоб упростить рез-т
     * В данном случае, передаём эти три выражения в массиве, потом возвращаем рез-т
     */
    public static Map<Double, Double> multiply(Map<Double, Double> first, Map<Double, Double> second) {

        List<Map<Double, Double>> result = new ArrayList<>();

        for (Map.Entry<Double, Double> f : first.entrySet()) {

            Map<Double, Double> multiplyRes = new HashMap<>();

            for (Map.Entry<Double, Double> s : second.entrySet()) {
                //степени складываются, коэффициенты умножаются
                double pow = f.getKey() + s.getKey();
                double k = f.getValue() * s.getValue();
                multiplyRes.put(pow, k);
            }

            result.add(multiplyRes);
        }
        return sum(result);
    }

    public static Map<Double, Double> multiply(List<Map<Double, Double>> mapList) {

        assert !mapList.isEmpty();

        while (mapList.size() > 1) {
            Map<Double, Double> temp = multiply(mapList.get(1), mapList.get(0));

            mapList.remove(0);
            mapList.remove(0);
            mapList.add(temp);
        }

        return mapList.get(0);
    }

    public static Map<Double, Double> multiply(Map<Double, Double> map, double num) {
        map.replaceAll((k, v) -> v * num);
        return map;
    }

    /*
     * Суммирует выражения из многочлена:
     * (x^5 - 2x^3 - x^2) + (3x^4 - 6x^2 - 3x) + (x^3 - 2x - 1)
     * В реализации используется словарь с сортировкой
     */
    public static Map<Double, Double> sum(List<Map<Double, Double>> polynomial) {
        Map<Double, Double> res = new TreeMap<>(Collections.reverseOrder());

        for (Map<Double, Double> l : polynomial) {
            for (Map.Entry<Double, Double> pair : l.entrySet()) {

                Double pairKey = pair.getKey();

                if (res.containsKey(pairKey)) {
                    res.put(pairKey, res.get(pairKey) + pair.getValue());
                } else {
                    res.put(pairKey, pair.getValue());
                }
            }
        }
        return res;
    }


    /*
                В Java для часто меняющихся строковых переменных используют StringBuilder.
                функция append() всего лишь добавляет строку в конец
                далее использую RegEx, чтоб привести строку в приятный математику вид
        */

    public static String toString(Map<Double, Double> map) {
        DecimalFormat df = new DecimalFormat("#.###");
        StringBuilder s = new StringBuilder();

        for (Map.Entry<Double, Double> p : map.entrySet()) {
            double key = p.getKey();
            double value = p.getValue();

            s.append(df.format(value)).append("x^").append(key).append("+");
        }
        s.insert(0, "L(x) = ");

        //удаляем лишние символы
        s.deleteCharAt(s.length() - 1);

        return s.toString()
                .replaceAll("\\+-", "-")
                .replaceAll("\\.999", "")
                .replaceAll("\\.0", "")
                .replaceAll("\\^1", "")
                .replaceAll("x\\^0", "")
                .replaceAll("1x", "x");
    }



}