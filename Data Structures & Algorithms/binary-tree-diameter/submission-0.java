/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBinaryTree(root, 0);
    }

    private int diameterOfBinaryTree(TreeNode root, int max) {
        if (root == null) {
            return max;
        }

        var leftMaxDepth = maxDepth(root.left, 0);
        var rightMaxDepth = maxDepth(root.right, 0);
        var diameter = Integer.max(max, leftMaxDepth + rightMaxDepth);
        var left = diameterOfBinaryTree(root.left, diameter);
        var right = diameterOfBinaryTree(root.right, diameter);
        return Integer.max(left, right);

    }

    private int maxDepth(TreeNode root, int max) {
        if (root == null) {
            return max;
        }
        var left = maxDepth(root.left, max);
        var right = maxDepth(root.right, max);
        return 1 + Integer.max(left, right);
    }
}
