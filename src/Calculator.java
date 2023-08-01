public class Calculator {

    public static int add(int num1, int num2){
        int add = num1 + num2;
        return add;
    }
    public static int subtract(int num1, int num2){
        int subtract = num1 - num2;
        return subtract;
    }
    public static int multiply(int num1, int num2){
        int multiply = num1 * num2;
        return multiply;
    }

    public static int divide(int num1, int num2) {
        if (num2 == 0) {
            System.out.print("Error: Division by zero is not allowed.");
            return 0;
        } else {
            int divide = num1 / num2;
            return divide;
        }
    }

    public static int square (double num1){
        double square = num1 * num1;
        return (int) square;
    }



}
