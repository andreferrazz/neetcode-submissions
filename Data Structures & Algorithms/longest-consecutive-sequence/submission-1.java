class Solution {
    public int longestConsecutive(int[] nums) {
        var set = new HashSet<Integer>();

        for (var num : nums) {
            set.add(num);
        }

        var result = 0;

        for (var num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }

            var i = 1;

            while (set.contains(num + i)) {
                i++;
            }

            result = Math.max(i, result);
        }

        return result;
    }
}
