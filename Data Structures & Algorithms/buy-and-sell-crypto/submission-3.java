class Solution {
    public int maxProfit(int[] prices) {
        var max = 0;
                    for (int i =0;i<prices.length-1;i++){
                                    for(int j=i+1; j < prices.length; j++){
                                                        max = Integer.max(max, prices[j] - prices[i]);
                                                                        }
                                                                                    }
                                                                                                return max;
    }
}
