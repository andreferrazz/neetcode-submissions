class Solution {
    public List<List<Integer>> subsets(int[] nums) { // O(2^s * n)
        var result = new ArrayList<List<Integer>>();
        subsets(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void subsets(int[] nums, int i, List<Integer> subset, List<List<Integer>> subsets) {
        if (i >= nums.length) {
            subsets.add(subset);
            return;
        }

        var without = new ArrayList<Integer>(subset);
        var with = new ArrayList<Integer>(subset);
        with.add(nums[i]);
        subsets(nums, i + 1, without, subsets);
        subsets(nums, i + 1, with, subsets);
    }
}
