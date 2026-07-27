class Solution {
    public int maxProfit(int[] prices) {
        int min_value = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min_value) {
                min_value = prices[i];
            }
            int profit = prices[i] - min_value;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}