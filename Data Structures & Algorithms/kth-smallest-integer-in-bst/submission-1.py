# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        
        def dfs(node, acc):
            if node.left:
                res = dfs(node.left, acc)
                if res:
                    return res

            acc["count"] -= 1

            if acc["count"] == 0:
                return node.val

            if node.right:
                res = dfs(node.right, acc)
                if res:
                    return res

        return dfs(root, { "count": k })