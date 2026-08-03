class Solution {
    public int maxProfit(int[] prices) {
        int mn=prices[0];
        int res=0;
        for(int i=1;i<prices.length;i++){
            mn=Math.min(prices[i],mn);
            res=Math.max(res,prices[i]-mn);
        }
        return res;
    }
}