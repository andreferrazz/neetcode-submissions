# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        return self.countGoodNodes(root, [])
        

    def countGoodNodes(self, current, previous) -> int:
        if current is None:
            return 0

        good = 1

        for n in previous:
            if n > current.val:
                good = 0
                break
        
        previous.append(current.val)
        left = self.countGoodNodes(current.left, previous)
        right = self.countGoodNodes(current.right, previous)
        previous.pop()
        return good + left + right
