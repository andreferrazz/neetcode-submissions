class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        max_heap = [-x for x in stones]
        heapq.heapify(max_heap)

        while len(max_heap) > 1:
            havier = heapq.heappop(max_heap)
            secondHavier = heapq.heappop(max_heap)
            if secondHavier > havier:
                heapq.heappush(max_heap, havier - secondHavier)
        
        return -max_heap[0] if len(max_heap) == 1 else 0
        