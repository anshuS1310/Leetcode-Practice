class Solution {
    private static final int MOD = 1_000_000_007;
    private int m,n;
    private int[][][] mem;
    public int uniquePaths(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        mem=new int[m][n][2];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(mem[i][j],-1);
            }
        }
        return dfs(grid,0,0,0);
    }
    private int dfs(int [][]g , int i , int j, int dr){
        if(i<0 || i>=m || j<0 || j>=n){
            return 0;
        }
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(mem[i][j][dr]!=-1){
            return mem[i][j][dr];
        }
        long ct=0;
        if(g[i][j]==1){
            if(dr==0){
                ct=dfs(g,i+1,j,1);
            }else{
                ct=dfs(g,i,j+1,0);
            }
        }else{
            ct+=(dfs(g,i+1,j,1) + dfs(g,i,j+1,0))%MOD;
        }
        mem[i][j][dr]=(int)ct;
        return mem[i][j][dr];
    }
}