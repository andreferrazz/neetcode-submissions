class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        var left = 1;
        var right = getMax(piles);
        var result = right;

        while (left <= right) {
            var mid = (left + right) / 2;
            if (canEachAllPiles(piles, mid, h)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    } // O(log(m) * n)

    int getMax(int[] piles) {
        var max = 0;

        for (var pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }

        return max;
    }

    boolean canEachAllPiles(int[] piles, int rate, int h) {
        var hoursAcc = 0;
        for (var pile : piles) {
            hoursAcc += Math.ceil(pile / (double) rate);
            if (hoursAcc > h) {
                return false;
            }
        }

        return true;
    }
}
