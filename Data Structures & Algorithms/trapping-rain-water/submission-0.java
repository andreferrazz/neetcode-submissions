class Solution {
    public int trap(int[] height) {
        var result = 0;

        for (int i = 0; i < height.length - 1; i++) {
            var rightBarIndex = i + 1;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > height[rightBarIndex]) {
                    rightBarIndex = j;
                }

                if (height[rightBarIndex] >= height[i]) {
                    break;
                }
            }
            result += calculateArea(height, i, rightBarIndex);
            i = rightBarIndex - 1;
        }

        return result;
    }

    int calculateArea(int [] height, int leftIndex, int rightIndex) {
        var area = 0;
        var lowerBar = Integer.min(height[leftIndex], height[rightIndex]);
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            area += lowerBar - height[i];
        }
        return area;
    }
}
