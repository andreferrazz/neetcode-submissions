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
    public List<List<Integer>> levelOrder(TreeNode root) {
        var output = new LinkedList<List<Integer>>();
        var queue = new LinkedList<TreeNode>();
        
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            output.add(new ArrayList<Integer>());
            var queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                var node = queue.poll();
                output.get(output.size() - 1).add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return output;
    }
}
