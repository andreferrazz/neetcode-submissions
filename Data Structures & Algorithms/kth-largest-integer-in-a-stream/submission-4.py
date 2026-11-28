class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.largests = sorted(nums)
        while len(self.largests) > k:
            self.largests.pop(0)
        self.k = k - len(self.largests)

    def add(self, val: int) -> int:
        if self.k > 0:
            self.largests.append(val)
            self.largests.sort()
        elif val > self.largests[0]:
            self.largests[0] = val
            self.largests.sort()
        self.k -= 1
        return self.largests[0]
        
class TreeNode:
    def __init__(self, val, left, right):
        self.val = val
        self.left = left
        self.right = right
    