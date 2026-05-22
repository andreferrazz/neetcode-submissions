from sortedcontainers import SortedList

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        stones.sort(reverse=True)

        while len(stones) > 1:
            result = stones[0] - stones[1]
            if result > 0:
                stones[0] -= stones.pop(1)
                stones.sort(reverse=True)
            elif result < 0:
                stones[1] -= stones.pop(0)
                stones.sort(reverse=True)
            else:
                stones.pop(0)
                stones.pop(0)

        return stones[0] if stones else 0