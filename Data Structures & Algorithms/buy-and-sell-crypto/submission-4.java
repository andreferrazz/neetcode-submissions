class Solution {
    public int maxProfit(int[] prices) {
        var max = 0;
        var i = 0;
        var j = 1;
        while (j < prices.length) {
            max = Integer.max(max, prices[j] - prices[i]);
            if (prices[j] < prices[i]) {
                i = j;
            }
            j++;
        }
        return max;
    }
}
