class Solution {
    public int search(int[] nums, int target) {
        var i = 0;
        var j = nums.length - 1;
        while (i <= j) {
            var mid = ((j - i) / 2) + i;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
