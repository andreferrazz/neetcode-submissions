# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Codec:
    
    # Encodes a tree to a single string.
    def serialize(self, root: Optional[TreeNode]) -> str:
        if not root:
            return ""
        encoded = ""
        queue = deque()
        queue.append(root)
        while queue:
            node = queue.popleft()
            if node:
                queue.append(node.left)
                queue.append(node.right)
                encoded += f"{node.val},"
            else:
                encoded += "None,"
        return encoded[:-1]


        
    # Decodes your encoded data to tree.
    def deserialize(self, data: str) -> Optional[TreeNode]:
        if data == "":
            return None
        values = deque(data.split(','))
        root = TreeNode(int(values.popleft()))
        queue = deque()
        queue.append(root)
        while values:
            node = queue.popleft()
            left = values.popleft()
            right = values.popleft()
            if left != 'None':
                node.left = TreeNode(int(left))
                queue.append(node.left)
            if right != 'None':
                node.right = TreeNode(int(right))
                queue.append(node.right)
        return root
