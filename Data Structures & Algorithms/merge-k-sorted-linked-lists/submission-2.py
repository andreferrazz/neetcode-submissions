# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists or len(lists) == 0:
            return None

        while len(lists) > 1:
            merged = []
            for i in range(0, len(lists), 2):
                a = lists[i]
                b = lists[i + 1] if (i + 1) < len(lists) else None
                merged.append(self.mergeLists(a, b))
            lists = merged
        
        return lists[0]

    def mergeLists(self, a, b):
        dummy = ListNode()
        current = dummy
        while a or b:
            if b == None:
                current.next = ListNode(a.val)
                a = a.next
            elif a == None:
                current.next = ListNode(b.val)
                b = b.next
            elif a.val < b.val:
                current.next = ListNode(a.val)
                a = a.next
            else:
                current.next = ListNode(b.val)
                b = b.next
            current = current.next
        return dummy.next

        