class Solution {
    public int[] productExceptSelf(int[] nums) {
        var length = nums.length;
        var prefix = new int[length];
        var postfix = new int[length];
        var output = new int[length];
        
        for (int i = 0, j = length - 1; i < length; i++, j--) {
            if (i == 0) {
                prefix[i] = nums[i];
                postfix[j] = nums[j];
            } else {
                prefix[i] = prefix[i - 1] * nums[i];
                postfix[j] = postfix[j + 1] * nums[j];
            }
        }

        output[0] = postfix[1];
        output[length - 1] = prefix[length - 2];
        
        for (int i = 1; i < length - 1; i++) {
            output[i] = prefix[i - 1] * postfix[i + 1];
        }

        return output;
    }
}
