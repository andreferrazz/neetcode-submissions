class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] output = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int e : nums) {
            int count = map.getOrDefault(e, 0) + 1;
            map.put(e, count);

            boolean shouldSwap = false;
            int minCount = Integer.MAX_VALUE;
            int minElementIndex = -1;
            for (int i = 0; i < k; i++) {
                if (output[i] == e) {
                    shouldSwap = false;
                    break;
                }

                Integer x = map.get(output[i]);

                if (x == null) {
                    shouldSwap = false;
                    output[i] = e;
                    break;
                }

                if (x < minCount) {
                    shouldSwap = true;
                    minCount = x;
                    minElementIndex = i;
                }
            }

            if (shouldSwap && count > minCount) {
                output[minElementIndex] = e;
            }
        }

        return output;
    }
}
