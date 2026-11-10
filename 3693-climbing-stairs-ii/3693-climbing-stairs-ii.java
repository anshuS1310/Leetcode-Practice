class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[]= new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int c=costs[i-1];
            int mv=dp[i-1]+c+1;
            if(i>=2){
                mv=Math.min(mv,c+dp[i-2]+4);
            }
            if(i>=3){
                mv=Math.min(mv,c+dp[i-3]+9);
            }
            dp[i]=mv;
        }
        return dp[n];
    }
}