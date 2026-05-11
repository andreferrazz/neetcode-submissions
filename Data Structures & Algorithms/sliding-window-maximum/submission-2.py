class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        result = []
        queue = deque()

        for i in range(k):
            while len(queue) > 0 and nums[i] > nums[queue[-1]]:
                queue.pop()
            queue.append(i)
        
        result.append(nums[queue[0]])

        for i in range(k, len(nums)):
            while len(queue) > 0 and nums[i] > nums[queue[-1]]:
                queue.pop()
            queue.append(i)
            if queue[0] <= i - k:
                queue.popleft()
            result.append(nums[queue[0]])
        
        return result
        