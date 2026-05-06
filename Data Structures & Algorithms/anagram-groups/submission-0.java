class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        for (String s : strs) {
            boolean wasAdded = false;
            for (List<String> list : result) {
                if (this.isAnagram(s, list.get(0))) {
                    list.add(s);
                    wasAdded = true;
                }
            }

            if (!wasAdded) {
                List<String> newList = new ArrayList<>();
                newList.add(s);
                result.add(newList);
            }
        }

        return result;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Integer a = sCount.getOrDefault(s.charAt(i), 0);
            sCount.put(s.charAt(i), a + 1);
            Integer b = tCount.getOrDefault(t.charAt(i), 0);
            tCount.put(t.charAt(i), b + 1);
        }

        for (Map.Entry<Character, Integer> entry : sCount.entrySet()) {
            if (!entry.getValue().equals(tCount.get(entry.getKey()))) {
                return false;
            }
        }

        return true;
    }
}
