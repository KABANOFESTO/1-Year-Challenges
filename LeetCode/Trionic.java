package LeetCode;

class Solution {
    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long maxSum = Long.MIN_VALUE;
        for (int p = 1; p < n - 2; p++) {
            for (int q = p + 1; q < n - 1; q++) {

                long leftSum = nums[p];
                long tempSum = nums[p];
                for (int i = p - 1; i >= 0; i--) {
                    if (nums[i] < nums[i + 1]) {
                        tempSum += nums[i];
                        leftSum = tempSum;
                    } else {
                        break;
                    }
                }

                long middleSum = 0;
                boolean validMiddle = true;
                for (int i = p; i < q; i++) {
                    if (nums[i] <= nums[i + 1]) {
                        validMiddle = false;
                        break;
                    }
                }
                if (!validMiddle)
                    continue;

                for (int i = p + 1; i <= q; i++) {
                    middleSum += nums[i];
                }

                long rightSum = 0;
                for (int i = q + 1; i < n; i++) {
                    if (nums[i - 1] < nums[i]) {
                        rightSum += nums[i];
                    } else {
                        break;
                    }
                }

                if (rightSum > 0) {
                    maxSum = Math.max(maxSum, leftSum + middleSum + rightSum);
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 2, 5, 3, 4, 6, 1, 7 };
        long result = solution.maxSumTrionic(nums);
        System.out.println(result);
    }
}
