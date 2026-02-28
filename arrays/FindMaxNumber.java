package arrays;

public class FindMaxNumber {
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 2, 9, 3 };
        System.out.println(findMax(nums));
    }
}
