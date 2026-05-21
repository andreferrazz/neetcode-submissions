class Node:

    def __init__(self, key: int, val: int):
        self.key = key
        self.val = val
        self.previous = None
        self.next = None


class DoubleLinkedList:

    def __init__(self, capacity: int):
        self.left = Node(0, 0)
        self.right = Node(0, 0)
        self.left.next = self.right
        self.right.previous = self.left
        self.size = 0
        self.capacity = capacity

    def append(self, node: Node) -> None:
        self.right.previous.next = node
        node.previous = self.right.previous
        self.right.previous = node
        node.next = self.right
        self.size += 1

    def remove(self, node: Node) -> Node:
        node.previous.next = node.next
        node.next.previous = node.previous
        node.next = node.previous = None
        self.size -= 1
        return node


class LRUCache:

    def __init__(self, capacity: int):
        self.cache = dict()
        self.values = DoubleLinkedList(capacity)
        
    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]
            self.values.remove(node)
            self.values.append(node)
            return node.val
        return -1

    def put(self, key: int, value: int) -> None:        
        if key in self.cache:
            self.values.remove(self.cache[key])

        self.cache[key] = Node(key, value)
        self.values.append(self.cache[key])
            
        while self.values.size > self.values.capacity:
            del self.cache[self.values.left.next.key]
            self.values.remove(self.values.left.next)
