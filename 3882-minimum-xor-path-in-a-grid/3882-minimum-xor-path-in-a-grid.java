class Solution {
    private int a;
    private boolean [][][] mg;
    public int minCost(int[][] g) {
        a=Integer.MAX_VALUE;
        mg=new boolean [g.length][g[0].length][1024];
        dfs(g,0,0,0,g.length,g[0].length);
        return a;
    }
    private void dfs(int [][] g, int i,int j,int x,int m,int n){
        x^=g[i][j];
        if(a==0){
            return;
        }
        if(mg[i][j][x]==true){
            return;
        }
        mg[i][j][x]=true;
        if(i==m-1 && j==n-1){
            a=Math.min(a,x);
            return;
        }
        if(i<m-1){
            dfs(g,i+1,j,x,m,n);
        }
        if(j<n-1){
            dfs(g,i,j+1,x,m,n);
        }
    }
}