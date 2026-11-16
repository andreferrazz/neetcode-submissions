# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:

        def longestPath(node, acc):
            if node is None:
                return acc

            leftMaxDepth = maxDepth(node.left, 0)
            rightMaxDepth = maxDepth(node.right, 0)
            path = leftMaxDepth + rightMaxDepth

            acc = max(acc, path)

            leftLongestPath = longestPath(node.left, acc)
            rightLongestPath = longestPath(node.right, acc)

            return max(acc, leftLongestPath, rightLongestPath)

        def maxDepth(node, acc):
            if node is None:
                return acc

            leftMaxDepth = maxDepth(node.left, acc + 1)
            rightMaxDepth = maxDepth(node.right, acc + 1)

            return max(leftMaxDepth, rightMaxDepth)

        return longestPath(root, 0)

        