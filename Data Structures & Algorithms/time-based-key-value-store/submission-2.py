class TimeMap:

    def __init__(self):
        self.mapp = {}
        

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.mapp:
            self.mapp[key] = {}
        self.mapp[key][timestamp] = value
        

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.mapp:
            return ""
        
        keys = sorted(self.mapp[key].keys())
        previous = None
        
        for e in keys:
            if e == timestamp:
                return self.mapp[key][e]
            elif e > timestamp:
                return self.mapp[key][previous] if previous else ""
            else:
                previous = e

        return self.mapp[key][previous]
        
