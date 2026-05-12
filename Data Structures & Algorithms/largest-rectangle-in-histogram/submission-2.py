class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        largest = float("-inf")

        for i in range(len(heights)):
            toAppend = i
            while len(stack) > 0 and heights[i] < stack[-1][1]:
                largest = max(largest, stack[-1][1] * (i - stack[-1][0]))
                toAppend = stack.pop()[0]
            stack.append((toAppend, heights[i]))

        while len(stack) > 0:
            largest = max(largest, stack[-1][1] * (len(heights) - stack[-1][0]))
            stack.pop()
        
        return largest
