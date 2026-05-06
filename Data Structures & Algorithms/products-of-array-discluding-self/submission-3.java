class Solution {
    public int[] productExceptSelf(int[] nums) {
        var length = nums.length;
        var output = new int[length];

        var leftProduct = 1;

        for (int i = 0; i < length; i++) {
            output[i] = leftProduct;
            leftProduct *= nums[i];
        }

        var rightProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return output;
    }
}
