package LeetCode;

public class MaximumBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        MaximumBinaryTree solution = new MaximumBinaryTree();

        int[] nums = { 3, 2, 1, 6, 0, 5 };
        TreeNode root = solution.constructMaximumBinaryTree(nums);

        printTree(root);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right)
            return null;

        int maxIdx = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        TreeNode node = new TreeNode(nums[maxIdx]);
        node.left = build(nums, left, maxIdx - 1);
        node.right = build(nums, maxIdx + 1, right);

        return node;
    }

    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                System.out.print("null ");
            } else {
                System.out.print(curr.val + " ");
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
    }
}