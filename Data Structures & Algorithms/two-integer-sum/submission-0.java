class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer a = map.get(nums[i]);
            if (a != null) {
                return new int[] {a, i};
            } else {
                map.put(target - nums[i], i);
            }
        }

        throw new RuntimeException();
    }
}
