class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        result = []
        queue = deque()

        for i in range(k):
            while len(queue) > 0 and nums[i] > queue[-1]:
                queue.pop()
            queue.append(nums[i])
        
        result.append(queue[0])

        for i in range(k, len(nums)):
            if nums[i - k] == queue[0]:
                queue.popleft()
            while len(queue) > 0 and nums[i] > queue[-1]:
                queue.pop()
            queue.append(nums[i])
            result.append(queue[0])
        
        return result
        