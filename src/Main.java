import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to JJs Calculator\n" +
                "What would you like to do today?");

        String[] calculatorMethods = getMethodsFromClass(Calculator.class);
        String[] magicCalculatorMethods = getMethodsFromClass(MagicCalculator.class);

        String[] allMethods = mergeArrays(calculatorMethods, magicCalculatorMethods);

        while (true) {
            System.out.println("\nChoose an operation or type 'exit' to quit:");
            printMethods(allMethods);
            String opChoice = input.nextLine();

            if (opChoice.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for using JJs Calculator. Goodbye!");
                break;
            }

            boolean validOperation = false;
            for (String method : allMethods) {
                if (method.equalsIgnoreCase(opChoice)) {
                    validOperation = true;
                    break;
                }
            }

            if (validOperation) {
                int num1, num2, result;
                double dbNum, dbResult;
                switch (opChoice.toLowerCase()) {

                    case "subtract":
                        System.out.println("Please enter the first number:");
                        num1 = Integer.parseInt(input.nextLine());
                        System.out.println("Now enter the second number:");
                        num2 = Integer.parseInt(input.nextLine());
                        result = MagicCalculator.subtract(num1, num2);
                        System.out.printf("The subtraction result is: %d%n", result);
                        break;
                    case "square":
                        System.out.println("Please enter number to be squared:");
                        dbNum = Double.parseDouble(input.nextLine());
                        dbResult = MagicCalculator.square(dbNum);
                        System.out.printf("%s squared is: %f%n",dbNum, dbResult);
                        break;
                    case "add":
                        System.out.println("Please enter the first number:");
                        num1 = Integer.parseInt(input.nextLine());
                        System.out.println("Now enter the second number:");
                        num2 = Integer.parseInt(input.nextLine());
                        result = MagicCalculator.add(num1,num2);
                        System.out.printf("The addition result is: %d%n",result);
                        break;
                    case "divide":
                        System.out.println("Please enter the first number:");
                        num1 = Integer.parseInt(input.nextLine());
                        System.out.println("Now enter the second number:");
                        num2 = Integer.parseInt(input.nextLine());
                        result = MagicCalculator.divide(num1,num2);
                        if(num2 != 0){
                        System.out.printf("The division result is: %d%n",result);}
                        break;
                    case "multiply":
                        System.out.println("Please enter the first number:");
                        num1 = Integer.parseInt(input.nextLine());
                        System.out.println("Now enter the second number:");
                        num2 = Integer.parseInt(input.nextLine());
                        result = MagicCalculator.multiply(num1,num2);
                        System.out.printf("The addition result is: %d%n",result);
                        break;
                    case "cosine":
                        System.out.println("Please enter degrees:");
                        dbNum = Double.parseDouble(input.nextLine());
                        dbResult = MagicCalculator.cosine(dbNum);
                        System.out.printf("Cosine of %s degrees is: %f%n",dbNum, dbResult);
                        break;
                    case "tangent":
                        System.out.println("Please enter degrees:");
                        dbNum = Double.parseDouble(input.nextLine());
                        dbResult = MagicCalculator.tangent(dbNum);
                        System.out.printf("Tangent of %s degrees is: %f%n",dbNum, dbResult);
                        break;
                    case "factorial":
                        System.out.println("Please enter number to factor ");
                        BigInteger bigNum = input.nextBigInteger();
                        input.nextLine();
                        BigInteger bigResult = MagicCalculator.factorial(bigNum);
                        System.out.printf("The factorial of %s is %d",bigNum, bigResult);
                        break;
                    case "sin":
                        System.out.println("Please enter degrees:");
                        dbNum = Double.parseDouble(input.nextLine());
                        dbResult = MagicCalculator.sin(dbNum);
                        System.out.printf("Sin of %s degrees is: %f%n",dbNum, dbResult);
                        break;

                    default:
                       System.out.println("Invalid operation. Please choose a valid operation.");
                       break;
                }
            } else {
                System.out.println("Invalid operation. Please choose a valid operation.");
            }
        }

        input.close();
    }


    private static String[] getMethodsFromClass(Class<?> klass) {
        Method[] methods = klass.getDeclaredMethods();
        String[] methodNames = new String[methods.length];

        for (int i = 0; i < methods.length; i++) {
            methodNames[i] = methods[i].getName();
        }

        return methodNames;
    }

    private static String[] mergeArrays(String[] arr1, String[] arr2) {
        String[] mergedArray = new String[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, mergedArray, 0, arr1.length);
        System.arraycopy(arr2, 0, mergedArray, arr1.length, arr2.length);
        return mergedArray;
    }

    private static void printMethods(String[] methods) {
        for (String method : methods) {
            System.out.println(method);
        }
    }
}

