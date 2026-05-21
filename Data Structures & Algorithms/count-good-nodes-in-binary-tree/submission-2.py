# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        return self.countGoodNodes(root, root.val)
        

    def countGoodNodes(self, current, maxValue) -> int:
        if current is None:
            return 0
        good = 1 if current.val >= maxValue else 0
        maxValue = max(current.val, maxValue)
        left = self.countGoodNodes(current.left, maxValue)
        right = self.countGoodNodes(current.right, maxValue)
        return good + left + right
