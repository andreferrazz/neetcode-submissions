class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        largest = float("-inf")

        for index, height in enumerate(heights):
            toAppend = index
            while len(stack) > 0 and height < stack[-1][1]:
                poppedIndex, poppedHeight = stack.pop()
                toAppend = poppedIndex
                largest = max(largest, poppedHeight * (index - poppedIndex))
            stack.append((toAppend, height))

        while len(stack) > 0:
            index, height = stack.pop()
            largest = max(largest, height * (len(heights) - index))
        
        return largest
