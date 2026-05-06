class Solution {
    public int lengthOfLongestSubstring(String s) {
        var set = new LinkedHashSet<Character>();
        var longest = 0;
        
        for (var c : s.toCharArray()) {
            if (set.contains(c)) {
                longest = Integer.max(longest, set.size());
                var iterator = set.iterator();
                while(!iterator.next().equals(c)) {
                    iterator.remove();
                }
                iterator.remove();
            }
            set.add(c);
        }

        return Integer.max(longest, set.size());
    }
}
