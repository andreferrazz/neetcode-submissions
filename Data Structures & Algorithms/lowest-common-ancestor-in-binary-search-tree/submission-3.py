# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        isP = root.val == p.val
        isQ = root.val == q.val
        isThePathDivergent = p.val < root.val < q.val or q.val < root.val < p.val 
        
        if isP or isQ or isThePathDivergent:
            return root
        
        if root.val < p.val:
            return self.lowestCommonAncestor(root.right, p, q)

        if root.val > p.val:
            return self.lowestCommonAncestor(root.left, p, q)
        