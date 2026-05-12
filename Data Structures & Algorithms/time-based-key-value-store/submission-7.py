class TimeMap:

    def __init__(self):
        self.mapp = {}
        

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.mapp:
            self.mapp[key] = []
        self.mapp[key].append((timestamp, value))
        

    def get(self, key: str, timestamp: int) -> str:
        values = self.mapp.get(key, [])
        l = 0
        r = len(values) - 1
        res = ""

        while l <= r:
            mid = (l + r) // 2
            time, value = values[mid]
            if time == timestamp:
                res = value
                break;
            elif timestamp > time:
                res = value
                l = mid + 1
            else:
                r = mid - 1
        
        return res
        
