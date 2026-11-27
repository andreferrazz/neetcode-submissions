# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        def isValid(node, maxValue, minValue):
            if not node:
                return True

            if node.val >= maxValue or node.val <= minValue:
                return False
            
            left = isValid(node.left, node.val, minValue)
            right = isValid(node.right, maxValue, node.val)

            return left and right

        left = isValid(root.left, root.val, float("-inf"))
        right = isValid(root.right, float("inf"), root.val)
        return left and right
