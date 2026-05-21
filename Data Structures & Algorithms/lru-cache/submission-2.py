class Node:

    def __init__(self, key: int, val: int):
        self.key = key
        self.val = val
        self.previous = None
        self.next = None


class DoubleLinkedList:

    def __init__(self, capacity: int):
        self.left = None
        self.right = None
        self.size = 0
        self.capacity = capacity

    def tostring(self):
        acc = ""
        current = self.left
        while current:
            acc += f"({current.key}: {current.val}), "
            current = current.next
        return f"size={self.size} [{acc[0:len(acc) - 2]}]"

    def is_overflowing(self) -> bool:
        return self.size > self.capacity

    def is_right_node(self, node: Node):
        return node is self.right

    def append_right(self, node: Node) -> None:
        if self.size == 0:
            self.left = node
            self.right = node
        else:
            node.next = None
            node.previous = self.right
            self.right.next = node
            self.right = node
        self.size += 1

    def remove_left(self) -> Node:
        return self.remove(self.left)

    def remove(self, node: Node) -> Node:
        if self.size == 1:
            self.left = None
            self.right = None
            node.next = None
            node.previous = None
            self.size -= 1
            return node
        if node is self.left:
            self.left = node.next
            self.left.previous = None
            node.next = None
            node.previous = None
            self.size -= 1
            return node
        if node is self.right:
            self.right = node.previous
            self.right.next = None
            node.next = None
            node.previous = None
            self.size -= 1
            return node
        node.previous.next = node.next
        node.next.previous = node.previous
        node.next = None
        node.previous = None
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
            self.values.append_right(node)
            print(f"get({key})    -> {self.values.tostring()} -> {self.cachestring()}")
            return node.val
        return -1

    def put(self, key: int, value: int) -> None:
        node = self.cache.get(key, Node(key, value))
        
        if key in self.cache:
            node.val = value
            self.values.remove(node)

        self.values.append_right(node)
        
        if key not in self.cache:
            self.cache[key] = node
            
        if self.values.is_overflowing():
            removed = self.values.remove_left()
            if removed:
                del self.cache[removed.key]
        print(f"put({key}, {value}) -> {self.values.tostring()} -> {self.cachestring()}")

    def cachestring(self):
        acc = ""
        for k, v in self.cache.items():
            acc += f"{k}: {v.val}, "
        return f"[{acc[0:len(acc) - 2]}]"
