# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        if not subRoot:
            return True

        def dfs(node):
            if not node:
                return False
            elif node.val == subRoot.val and isSameTree(node, subRoot):
                return True
            else:
                return dfs(node.left) or dfs(node.right)

        def isSameTree(a, b):
            if not a and not b:
                return True
            elif not a or not b or a.val != b.val:
                return False
            else:
                return isSameTree(a.left, b.left) and isSameTree(a.right, b.right)

        return dfs(root)
