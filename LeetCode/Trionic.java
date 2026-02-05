package LeetCode;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = { 0, -2, -1, -3, 0, 2, -1 };
        System.out.println(solution.maxSumTrionic(nums1));

        int[] nums2 = { 1, 4, 2, 7 };
        System.out.println(solution.maxSumTrionic(nums2));

        int[] nums3 = { 1, 3, 2, 5 };
        System.out.println(solution.maxSumTrionic(nums3));
    }

    public long maxSumTrionic(int[] nums) {
        int n = nums.length;
        long maxSum = Long.MIN_VALUE;

        for (int p = 1; p < n - 2; p++) {
            for (int q = p + 1; q < n - 1; q++) {

                boolean validDec = true;
                for (int i = p; i < q; i++) {
                    if (nums[i] <= nums[i + 1]) {
                        validDec = false;
                        break;
                    }
                }
                if (!validDec)
                    continue;

                long bestLeft = nums[p];
                long tempSum = nums[p];
                for (int i = p - 1; i >= 0; i--) {
                    if (nums[i] < nums[i + 1]) {
                        tempSum += nums[i];
                        bestLeft = tempSum;
                    } else {
                        break;
                    }
                }

                long middle = 0;
                for (int i = p + 1; i <= q; i++) {
                    middle += nums[i];
                }

                long bestRight = 0;
                for (int i = q + 1; i < n; i++) {
                    if (nums[i - 1] < nums[i]) {
                        bestRight += nums[i];
                    } else {
                        break;
                    }
                }

                if (bestRight > 0) {
                    maxSum = Math.max(maxSum, bestLeft + middle + bestRight);
                }
            }
        }

        return maxSum;
    }
}
