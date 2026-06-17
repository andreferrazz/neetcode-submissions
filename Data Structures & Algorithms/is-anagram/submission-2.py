class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sCharCounter = dict()

        for c in s:
            if c in sCharCounter:
                sCharCounter[c] += 1
            else:
                sCharCounter[c] = 1
        
        tCharCounter = dict()

        for c in t:
            if c in tCharCounter:
                tCharCounter[c] += 1
            else:
                tCharCounter[c] = 1

        return sCharCounter == tCharCounter        
        