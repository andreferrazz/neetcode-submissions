class Solution {
    public int search(int[] nums, int target) {
        var left = 0;
        var right = nums.length - 1;

        while (left <= right) {
            var mid = (right + left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if ((nums[left] < nums[mid] && target >= nums[left] && target < nums[mid]) 
                || (nums[left] > nums[mid] && (target > nums[right] || target < nums[mid]))) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}