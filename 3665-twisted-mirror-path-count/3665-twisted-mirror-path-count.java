class Solution {
    private static final int MOD = 1_000_000_007;
    public int uniquePaths(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        if (m == 1 && n == 1) return 1;
        int dp[][][]=new int[m][n][2];
        dp[m-1][n-1][1]=1;
        dp[m-1][n-1][0]=1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    continue;
                }
                for(int d=0;d<2;d++){
                    if(grid[i][j]==1){
                        if(d==0){
                            if(i+1<m){
                                dp[i][j][0]=dp[i+1][j][1];
                            }
                            else{
                                dp[i][j][0]=0;
                            }
                        }else{
                            if(j+1<n){
                                dp[i][j][1]=dp[i][j+1][0];
                            }else{
                                dp[i][j][1]=0;
                            }
                        }
                    }else{
                        long r=0,l=0;
                        if(i+1<m){
                            l=dp[i+1][j][1];
                        }
                        if(j+1<n){
                            r=dp[i][j+1][0];
                        }
                        dp[i][j][d]=(int)((r+l)%MOD);
                    }
                }
            }
        }
        return dp[0][0][1];
    }
}