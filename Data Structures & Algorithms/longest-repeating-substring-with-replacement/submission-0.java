class Solution {
    public int characterReplacement(String s, int k) {
        var charFrequency = new HashMap<Character, Integer>();
        increment(charFrequency, s.charAt(0));
        var result = 0;
        var i = 0;
        var j = 0;

        while (j < s.length()) {
            var windowSize = j - i + 1;
            var mostFrequentChar = findMostFrequentChar(charFrequency);
            if (windowSize - mostFrequentChar <= k) {
                result = Integer.max(result, windowSize);
                j++;
                if (j < s.length()) {
                    increment(charFrequency, s.charAt(j));
                }
            } else {
                decrement(charFrequency, s.charAt(i));
                i++;
            }
        }

        return result;
    }

    void increment(Map<Character, Integer> charFrequency, char c) {
        charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
    }

    void decrement(Map<Character, Integer> charFrequency, char c) {
        charFrequency.put(c, charFrequency.get(c) - 1);
    }

    int findMostFrequentChar(Map<Character, Integer> charFrequency) {
        var max = 0;
        for (var count : charFrequency.values()) {
            max = Integer.max(max, count);
        }
        return max;
    }
}
