# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:

        node = root

        while node:
            isP = node.val == p.val
            isQ = node.val == q.val
            isThePathDivergent = p.val < node.val < q.val or q.val < node.val < p.val
        
            if isP or isQ or isThePathDivergent:
                return node
        
            if node.val < p.val:
                node = node.right
            elif node.val > p.val:
                node = node.left
        