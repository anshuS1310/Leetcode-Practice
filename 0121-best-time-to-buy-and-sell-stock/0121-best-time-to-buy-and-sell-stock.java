class Solution {
    public int maxProfit(int[] prices) {
        int c=0,b=-1,a=Integer.MAX_VALUE;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1] && a>prices[i]){
                b=i;
                a=prices[i];
            }
            if(b>=0){
                c=Math.max(c,prices[i+1]-prices[b]);
            }
        }
        return c;
    }
}