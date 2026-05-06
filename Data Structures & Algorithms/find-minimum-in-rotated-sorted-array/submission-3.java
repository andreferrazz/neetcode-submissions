class Solution {
    public int findMin(int[] nums) {
        var left = 0;
        var right = nums.length - 1;
        var res = 1001;

        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left <= right) {
            var mid = (left + right) / 2;
            if (nums[mid] >= nums[left]) {
                res = Integer.min(res, nums[mid]);
                left = mid == left ? ++mid : mid;
            } else {
                right = mid == right ? --mid : mid;
            }
        }

        return res;
    }
}
