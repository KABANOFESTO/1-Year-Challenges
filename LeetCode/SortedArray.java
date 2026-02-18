package LeetCode;

public class SortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int lo = 0, hi = m;

        while (lo <= hi) {
            int partition1 = (lo + hi) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            int maxLeft1  = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2  = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((m + n) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2);
                } else {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            } else if (maxLeft1 > minRight2) {
                hi = partition1 - 1;
            } else {
                lo = partition1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }

    public static void main(String[] args) {
        SortedArray solution = new SortedArray();

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Test 1: " + solution.findMedianSortedArrays(nums1, nums2));

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("Test 2: " + solution.findMedianSortedArrays(nums3, nums4));

        int[] nums5 = {};
        int[] nums6 = {1};
        System.out.println("Test 3: " + solution.findMedianSortedArrays(nums5, nums6));

      
        int[] nums7 = {1, 2, 3};
        int[] nums8 = {4, 5, 6};
        System.out.println("Test 4: " + solution.findMedianSortedArrays(nums7, nums8));
    }
}
