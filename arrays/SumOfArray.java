package arrays;

public class SumOfArray {
  public static void NumberSum(int[] arr) {
    int sum = 0;
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];
      arr[i] = sum;
    }
  }

  public static void main(String[] args) {
    int[] numbers = {1, 2, 3, 4, 5};
    NumberSum(numbers);
    for (int num : numbers) {
      System.out.println(num);
    }
  }
}