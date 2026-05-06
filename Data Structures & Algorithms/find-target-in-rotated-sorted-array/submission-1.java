class Solution {
    public int search(int[] nums, int target) {
        var left = 0;
        var right = nums.length - 1;
        var mid = left + right / 2;

        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            }
            
            if ((nums[left] < nums[mid] && target >= nums[left] && target < nums[mid]) 
                || (nums[left] > nums[mid] && (target > nums[right] || target < nums[mid]))) {
                right = mid;
                mid = (right + left) / 2;
            } else {
                left = mid + 1;
                mid = (right + left) / 2;
            }
        }

        return -1;
    }
}