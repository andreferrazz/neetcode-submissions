# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        
        def dfs(node, maxValue):
            if not node:
                return 0
            
            isGoodNode = 0

            if node.val >= maxValue:
                isGoodNode = 1
                maxValue = node.val
            
            left = dfs(node.left, maxValue)
            right = dfs(node.right, maxValue)

            return left + right + isGoodNode

        return dfs(root, -101)