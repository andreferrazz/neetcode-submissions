class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        numsSet = set()

        for n in nums:
            if n in numsSet:
                return n
            numsSet.add(n)
        
        raise RuntimeError("Duplicate not found")