class Solution {
    private boolean chk(int i,int j,int[][] g){
        if(i<0 || i>=g.length|| j<0 || j>=g[0].length){
            return false;
        }
        if(g[i][j]==1){
            return true;
        }
        g[i][j]=1;
        return chk(i+1,j,g) & chk(i-1,j,g) & chk(i,j-1,g) & chk(i,j+1,g);
    }
    public int closedIsland(int[][] grid) {
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0 && chk(i,j,grid)){
                    c++;
                }
            }
        }
        return c;
    }
}