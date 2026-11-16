# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:

        def doMaxDepth(node, acc: int):
            if node is None:
                return acc
            
            leftDepth = doMaxDepth(node.left, acc + 1)
            rightDepth = doMaxDepth(node.right, acc + 1)

            return max(leftDepth, rightDepth)
        
        return doMaxDepth(root, 0);
   