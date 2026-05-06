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
        var depths = new HashMap<TreeNode, Integer>();
        calculateDepths(root, depths);
        return diameterOfBinaryTree(root, depths, 0);
    }

    private int diameterOfBinaryTree(TreeNode root, Map<TreeNode, Integer> depths, int max) {
        if (root == null) {
            return max;
        }

        var current = depths.getOrDefault(root.left, 0) + depths.getOrDefault(root.right, 0);
        max = Integer.max(max, current);
        var left = diameterOfBinaryTree(root.left, depths, max);
        max = Integer.max(max, left);
        var right = diameterOfBinaryTree(root.right, depths, max);
        max = Integer.max(max, right);
        return max;
    }

    private int calculateDepths(TreeNode root, Map<TreeNode, Integer> depths) {
        if (root == null) {
            return 0;
        }
        var left = calculateDepths(root.left, depths);
        var right = calculateDepths(root.right, depths);
        var depth = 1 + Integer.max(left, right);
        depths.put(root, depth);
        return depth;
    }
}
