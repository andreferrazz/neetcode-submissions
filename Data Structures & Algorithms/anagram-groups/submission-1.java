class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (String s : strs) {
            List<Integer> array = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

            for (char c : s.toCharArray()) {
                int i = c - 'a';
                array.set(i, array.get(i) + 1);
            }

            map.putIfAbsent(array, new ArrayList<>());
            List<String> list = map.get(array);
            list.add(s);
        }

        return map.values().stream().toList();
    }
}
