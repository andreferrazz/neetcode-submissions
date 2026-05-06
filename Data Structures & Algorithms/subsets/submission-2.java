class Solution {
    public List<List<Integer>> subsets(int[] nums) { // O(2^n * n)
        var result = new ArrayList<List<Integer>>();
        subsets(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void subsets(int[] nums, int i, List<Integer> subset, List<List<Integer>> subsets) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<Integer>(subset));
            return;
        }
        subset.add(nums[i]);
        subsets(nums, i + 1, subset, subsets);
        subset.remove(subset.size() - 1);
        subsets(nums, i + 1, subset, subsets);
    }
}
