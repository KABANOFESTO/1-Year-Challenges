package Recursion;

public class fibonaccith {

    public static int fibonacci(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid input, use a positive number");
        }

        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            int[] fibArray = new int[n];
            fibArray[0] = 0;
            fibArray[1] = 1;

            for (int i = 2; i < n; i++) {
                fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
            }

            return fibArray[n - 1];
        }
    }

    public static void main(String[] args) {
        int number = 4;
        int result = fibonacci(number);
        System.out.println(result);
    }
}
