# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        res = None

        for l in lists:
            current = l
            while current != None:
                if res == None:
                    res = ListNode(current.val)
                elif res.val > current.val:
                    node = ListNode(current.val)
                    node.next = res
                    res = node
                else:
                    resCurrent = res
                    while resCurrent != None:
                        if resCurrent.next == None:
                            resCurrent.next = ListNode(current.val)
                            break
                        elif resCurrent.next.val > current.val:
                            node = ListNode(current.val)
                            node.next = resCurrent.next
                            resCurrent.next = node
                            break
                        resCurrent = resCurrent.next
                current = current.next

        return res