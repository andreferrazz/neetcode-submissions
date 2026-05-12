class TimeMap:

    def __init__(self):
        self.mapp = {}
        

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.mapp:
            self.mapp[key] = []
        self.mapp[key].append((timestamp, value))
        

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.mapp:
            return ""
        
        previous = ""
        
        for i, (currentTimestamp, value) in enumerate(sorted(self.mapp[key])):
            if currentTimestamp == timestamp:
                return value
            elif currentTimestamp < timestamp:
                previous = value
            else:
                return previous
        
        return previous
