class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        largest = float("-inf")
        
        for i in range(len(heights)):
            minHeight = float("inf")
            for j in range(i, len(heights)):
                minHeight = min(minHeight, heights[j])
                largest = max(largest, minHeight * (j - i + 1))

        return largest
        