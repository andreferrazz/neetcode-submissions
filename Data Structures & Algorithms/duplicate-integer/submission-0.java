class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int e : nums) {
            Boolean exists = map.get(e);
            if (exists == null || exists == false) {
                map.put(e, true);
            } else {
                return true;
            }
        }

        return false;
    }
}
