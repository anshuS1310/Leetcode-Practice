class Solution {
    private static final int MOD = 1_000_000_007;
    public int uniquePaths(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int dp[][][]=new int[m][n][2];
        if(m>1) dp[1][0][1]=1;
        if(n>1) dp[0][1][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int d=0;d<2;d++){
                    int w=dp[i][j][d];
                    if(w==0){
                        continue;
                    }
                    if(grid[i][j]==1){
                        if(d==0){
                            if(i+1<m){
                                dp[i+1][j][1]=(dp[i+1][j][1] + w) % MOD;
                            }
                        }else{
                            if(j+1<n){
                                dp[i][j+1][0]=(dp[i][j+1][0]+w) % MOD;
                            }
                        }
                    }else{
                        if(i+1<m){
                            dp[i+1][j][1]=(dp[i+1][j][1]+w)%MOD;
                        }
                        if(j+1<n){
                            dp[i][j+1][0]=(dp[i][j+1][0]+w) % MOD;
                        }
                    }
                }
            }
        }
        int ans= (int) ((dp[m-1][n-1][0]+dp[m-1][n-1][1])%MOD);
        return ans;
    }
}