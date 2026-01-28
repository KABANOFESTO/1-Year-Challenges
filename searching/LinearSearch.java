package searching;

public class LinearSearch {

    public static int LinearSearching(int nums[], int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 10, 20, 30, 40, 50 };
        int target = 30;
        int result = LinearSearching(nums, target);

        if(result==-1)
        {
            System.out.println("Element not found");
        }else
        {
            System.out.println("Element found at index: " + result);
        }
    }
}
