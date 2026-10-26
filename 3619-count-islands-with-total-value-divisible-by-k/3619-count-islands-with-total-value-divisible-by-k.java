class Solution {
    private long chk(int i,int j,int[][]g,long r){
        if(i<0 || i>=g.length || j<0 || j>=g[0].length){
            return 0;
        }
        if(g[i][j]==0){
            return 0;
        }
        r=g[i][j];
        g[i][j]=0;
        return r+chk(i+1,j,g,r)+chk(i-1,j,g,r)+chk(i,j+1,g,r)+chk(i,j-1,g,r);
    }
    public int countIslands(int[][] grid, int k) {
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                long r=0;
                if(grid[i][j]>0 && chk(i,j,grid,r)%k==0){
                    c++;
                }
            }
        }
        return c;
    }
}