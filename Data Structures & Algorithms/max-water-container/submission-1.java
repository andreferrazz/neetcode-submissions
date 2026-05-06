class Solution {
    public int maxArea(int[] heights) {
        var maxContainerSize = 0;

        for (int i = 0; i < heights.length - 1; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                var lowerBar = Integer.min(heights[i], heights[j]);
                var containerSize = lowerBar * (j - i);
                maxContainerSize = Integer.max(containerSize, maxContainerSize);
            }
        }

        return maxContainerSize;
    }
}
