class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : nums) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        List<List<Integer>> aux = new ArrayList<>(nums.length + 1);
        for (int i = 0; i < nums.length + 1; i++) {
            aux.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            aux.get(entry.getValue()).add(entry.getKey());
        }

        int[] output = new int[k];
        for (int i = nums.length, j = 0; i >= 0; i--) {
            for (Integer e : aux.get(i)) {
                output[j] = e;
                j++;
                if (j >= k) {
                    return output;
                }
            }
        }

        return output;
    }
}
