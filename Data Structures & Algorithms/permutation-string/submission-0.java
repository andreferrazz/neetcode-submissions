class Solution {
    public boolean checkInclusion(String s1, String s2) {
        var sortedS1 = sortString(s1);
        
        for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
            var slice = s2.substring(i, i + s1.length());
            if (sortString(slice).equals(sortedS1)) {
                return true;
            }
        }

        return false;
    }

    String sortString(String s) {
        var stringArray = s.toCharArray();
        Arrays.sort(stringArray);
        return new String(stringArray);
    }
}

// n = s1.length
// k = s2.length
// O(k * n * log n)