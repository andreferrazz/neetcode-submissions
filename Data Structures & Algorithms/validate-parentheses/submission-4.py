class Solution:
    def isValid(self, s: str) -> bool:
        brackets = { ")": "(", "]": "[", "}": "{" }
        stack = []
        for c in s:
            if len(stack) == 0 or c in brackets.values():
                stack.append(c)
            elif stack[-1] == brackets[c]:
                stack.pop()
            else:
                return False
        return len(stack) == 0
