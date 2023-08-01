import java.math.BigInteger;

class MagicCalculator extends Calculator {
    public static double sin(double num1) {
        double radians = Math.toRadians(num1);
        return Math.sin(radians);
    }
    public static double cosine(double num1) {
        double radians = Math.toRadians(num1); // Convert the input number to radians
        return Math.cos(radians);
    }
    public static double tangent(double num1) {
        double radians = Math.toRadians(num1); // Convert the input number to radians
        return Math.tan(radians);
    }
    public static BigInteger factorial(BigInteger number) {
        BigInteger result = BigInteger.valueOf(1);

        for (long factor = 2; factor <= number.longValue(); factor++) {
            result = result.multiply(BigInteger.valueOf(factor));
        }
        return result;
    }
}
