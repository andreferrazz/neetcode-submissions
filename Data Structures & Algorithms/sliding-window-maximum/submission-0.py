class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        i = 0
        j = k
        result = []
        while j <= len(nums):
            maxValue = float("-inf")
            for n in nums[i:j]:
                maxValue = max(maxValue, n)
            result.append(maxValue)
            i += 1
            j += 1
        return result
        