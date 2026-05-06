class Solution:
    def minWindow(self, s: str, t: str) -> str:
        targetCount = dict()
        windowCount = dict()
        
        for c in t:
            windowCount.setdefault(c, 0)
            targetCount.setdefault(c, 0)
            targetCount[c] += 1
        
        matches = 0
        need = len(set(t))
        i = 0
        j = -1
        result = ()
        
        while j < len(s) - 1 or matches == need:
            if matches < need:
                j += 1
                c = s[j]
                if c in targetCount:
                    windowCount[c] += 1
                    if windowCount[c] == targetCount[c]:
                        matches += 1
            else:
                if len(result) == 0 or j - i < result[1] - result[0]:
                    result = (i, j)
                c = s[i]
                if c in targetCount:
                    windowCount[c] -= 1
                    if windowCount[c] < targetCount[c]:
                        matches -= 1
                i += 1

        return "" if len(result) == 0 else s[result[0]:result[1] + 1]

