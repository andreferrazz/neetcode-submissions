class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        
        for (var i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        var arr = new ArrayList<int[]>(); 
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }

        arr.sort((a, b) -> b[0] - a[0]);

        return arr.stream().limit(k).mapToInt(e -> e[1]).toArray();
    }
}
