class Solution {
    public int[] productExceptSelf(int[] nums) {
        var product = 1;
        var zeroCount = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                product *= nums[i];
            }
        }

        var result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 1) {
                result[i] = 0;
            } else if (nums[i] == 0) {
                result[i] = product;
            } else if (zeroCount == 1) {
                result[i] = 0;
            } else {
                result[i] = product / nums[i];
            }
        }

        return result;
    }
}
