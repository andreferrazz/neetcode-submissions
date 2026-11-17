# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        balanced = True
        
        def depth(node):
            nonlocal balanced
            if node is None:
                return 0
            left = depth(node.left)
            right = depth(node.right)
            balanced = balanced and (-1 <= left - right <= 1)
            return max(left, right) + 1
        
        depth(root)
        return balanced