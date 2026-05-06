class Solution {
    class Car {
        int position;
        int speed;
        double time;

        Car(int position, int speed, int target) {
            this.position = position;
            this.speed = speed;
            this.time = (target - position) / (double) speed;
        }

        public String toString() {
            return "{ " + this.position + ", " + this.speed + ", " + this.time + " }";
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        var cars = new ArrayList<Car>(position.length);
        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], speed[i], target));
        }

        Collections.sort(cars, (a, b) -> {
            if (a.position > b.position) return 1;
            if (a.position < b.position) return -1;
            return 0;
        });

        var fleets = new Stack<Car>();
        var result = position.length;

        for (int i = cars.size() - 1; i >= 0; i--) {
            var car = cars.get(i);
            if (fleets.isEmpty() || car.time > fleets.peek().time) {
                fleets.push(car);
            }
        }

        return fleets.size();
    }
}
