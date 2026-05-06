class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();

        for (String s : strs) {
            var charArray = s.toCharArray();
            Arrays.sort(charArray);
            var sorted = new String(charArray);
            var group = map.getOrDefault(sorted, new ArrayList<String>());
            if (group.isEmpty()) {
                map.put(sorted, group);
            }
            group.add(s);
        }

        return new ArrayList<>(map.values());
    }
}
