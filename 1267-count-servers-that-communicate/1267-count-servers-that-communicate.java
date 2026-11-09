class Solution {
    private void dfs(int r,int c,int [][] g,int rn,int cn,List<int[]> cp){
        g[r][c]=2;
        cp.add(new int[]{r,c});
        for(int ci=0;ci<cn;ci++){
            if(g[r][ci]==1){
                dfs(r,ci,g,rn,cn,cp);
            }
        }
        for(int ri=0;ri<rn;ri++){
            if(g[ri][c]==1){
                dfs(ri,c,g,rn,cn,cp);
            }
        }
    }
    public int countServers(int[][] grid) {
        int rn=grid.length,cn=grid[0].length;
        Set<String> s=new HashSet<>();
        for(int r=0;r<rn;r++){
            for(int c=0;c<cn;c++){
                if(grid[r][c]==1){
                    List<int[]> cp=new ArrayList<>();
                    dfs(r,c,grid,rn,cn,cp);
                    if(cp.size()>1){
                        for(int []a:cp){
                            s.add(a[0]+","+a[1]);
                        }
                    }
                }

            }
        }
        return s.size();
    }
}