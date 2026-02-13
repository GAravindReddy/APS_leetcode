class Solution {
    public int maxProfit(int[] prices) {
        int minimum= prices[0];
        int maxprofit=0;
        for (int i=1; i< prices.length; i++){
            int cost= prices[i] - minimum;
            maxprofit= Math.max(maxprofit, cost);
            minimum= Math.min(minimum, prices[i]);
        }
        return maxprofit;
    }
}