# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def dfs(node, maxAllowed, minAllowed):
            if not node:
                return True
            if node.val >= maxAllowed or node.val <= minAllowed:
                return False
            left = dfs(node.left, node.val, minAllowed)
            right = dfs(node.right, maxAllowed, node.val)
            return left and right
            
        return dfs(root, float("inf"), float("-inf"))
        