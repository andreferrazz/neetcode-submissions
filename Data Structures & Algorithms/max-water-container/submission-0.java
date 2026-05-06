class Solution {
    public int maxArea(int[] heights) {
        var maxContainerSize = 0;

        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                var lowerBar = heights[i] < heights[j] ? heights[i] : heights[j];
                var containerSize = lowerBar * (j - i);
                if (containerSize > maxContainerSize) {
                    maxContainerSize = containerSize;
                }
            }
        }

        return maxContainerSize;
    }
}
