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

    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        calculateDepthAndUpdateIsBalanced(root);
        return isBalanced;
    }

    private int calculateDepthAndUpdateIsBalanced(TreeNode root) {
        if (root == null) {
            return 0;
        }

        var left = calculateDepthAndUpdateIsBalanced(root.left);
        var right = calculateDepthAndUpdateIsBalanced(root.right);
        isBalanced = isBalanced && (left - right >= -1 && left - right <= 1);
        return 1 + Integer.max(left, right);
    }


}
