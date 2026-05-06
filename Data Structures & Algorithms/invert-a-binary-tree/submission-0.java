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
    public TreeNode invertTree(TreeNode root) {
        doInvertTree(root);
        return root;
    }

    private void doInvertTree(TreeNode node) {
        if (node == null) {
            return;
        }
        var left = node.left;
        var right = node.right;
        node.left = right;
        node.right = left;
        doInvertTree(left);
        doInvertTree(right);
    }
}
