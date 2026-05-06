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

    private int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateDiameterOfBinaryTree(root);
        return result;
    }

    private int calculateDiameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        var left = calculateDiameterOfBinaryTree(root.left);
        var right = calculateDiameterOfBinaryTree(root.right);
        result = Integer.max(result, left + right);
        return 1 + Integer.max(left, right);
    }
}
