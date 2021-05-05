package alimMath;

public class Coders {

    public static int codeGray(int x) {
        return (x > 0) ? x ^ (x >> 1) : 0;
    }

    public static int encodeGray(String binaryX) {
        int x = Integer.parseInt(binaryX, 2);
        return encodeGray(x);
    }

    public static StringBuffer encodeGray(String binaryX, StringBuffer buffer) {
        int x = Integer.parseInt(binaryX, 2);
        return encodeGray(x, buffer);
    }

    public static int encodeGray(int x) {
        int b;
        for (b = 0; x > 0; x >>= 1) {
            b ^= x;
        }
        return b;
    }

    public static StringBuffer encodeGray(int x, StringBuffer buffer) {
        int b = 0;
        int length = Integer.toBinaryString(x).length();

        for (int i = 0; x > 0; x >>= 1, ++i) {
            String rightX = Integer.toBinaryString(x);

            int countZero = length - rightX.length();
            buffer.append("0".repeat(Math.max(0, countZero)));

            buffer.append(rightX).append("\n");
            b ^= x;
        }
        buffer.append("-".repeat(length)).append("\n");
        buffer.append(String.format("%s\n", Integer.toBinaryString(b)));

        return buffer;
    }
}