class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        var count1 = new HashMap<Character, Integer>();
        var count2 = new HashMap<Character, Integer>();
        var s1Chars = s1.toCharArray();
        var s2Chars = s2.toCharArray();
        var matches = 0;

        for (char c = 'a'; c <= 'z'; c++) {
            count1.put(c, 0);
            count2.put(c, 0);
        }

        for (int i = 0; i < s1Chars.length; i++) {
            count1.put(s1Chars[i], count1.get(s1Chars[i]) + 1);
            count2.put(s2Chars[i], count2.get(s2Chars[i]) + 1);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            if (count1.get(c) == count2.get(c)) {
                matches++;
            }
        }

        for (int left = 0, right = s1Chars.length; right < s2Chars.length; left++, right++) {
            if (matches == 26) {
                return true;
            }

            var rightChar = s2Chars[right];
            count2.put(rightChar, count2.get(rightChar) + 1);

            if (count1.get(rightChar) == count2.get(rightChar)) {
                matches++;
            } else if (count1.get(rightChar) + 1 == count2.get(rightChar)) {
                matches--;
            }

            var leftChar = s2Chars[left];
            count2.put(leftChar, count2.get(leftChar) - 1);

            if (count1.get(leftChar) == count2.get(leftChar)) {
                matches++;
            } else if (count1.get(leftChar) - 1 == count2.get(leftChar)) {
                matches--;
            }
        }

        return matches == 26;
    }
}
