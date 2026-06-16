# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode()
        tail = dummy
        queue = deque()
        i = 0
        current = head
        while current:
            queue.append(current)
            i += 1
            current = current.next
            if i % k == 0:
                while len(queue) > 0:
                    tail.next = queue.pop()
                    tail = tail.next
                tail.next = None
        while len(queue) > 0:
            tail.next = queue.popleft()
            tail = tail.next
        tail.next = None
        return dummy.next
