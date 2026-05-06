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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        var pAncestors = stackAncestors(root, p, new Stack<TreeNode>()); // O(n)
        var qAncestors = stackAncestors(root, q, new Stack<TreeNode>()); // O(n)
        return getCommonAncestor(pAncestors, qAncestors); // O(2 * n)
    } // O(n)

    private TreeNode getCommonAncestor(Stack<TreeNode> pAncestors, Stack<TreeNode> qAncestors) {
        while (!pAncestors.isEmpty() && !qAncestors.isEmpty()) {
            if (pAncestors.peek().val == qAncestors.peek().val) {
                return pAncestors.peek();
            }

            if (pAncestors.size() > qAncestors.size()) {
                pAncestors.pop();
            } else {
                qAncestors.pop();
            }
        }

        return null;
    }

    private Stack<TreeNode> stackAncestors(TreeNode root, TreeNode target, Stack<TreeNode> ancestors) {
        if (root == null) {
            return ancestors;
        }

        ancestors.push(root);

        if (target.val < root.val) {
            return stackAncestors(root.left, target, ancestors);
        } else if (target.val > root.val) {
            return stackAncestors(root.right, target, ancestors);
        } else {
            return ancestors;
        }
    }
}
