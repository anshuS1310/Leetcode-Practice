class Solution {
    public int uniquePaths(int[][] grid) {
        int m = 1_000_000_007;
        int n = grid[0].length;
        int[]r = new int[n+1];
        int []d=new int[n+1];
        r[0]=1;
        for(int []rw:grid){
            for(int i=0;i<n;i++){
                if(rw[i]==0){
                    int c=(d[i+1]+r[i])%m;
                    d[i+1]=c;
                    r[i+1]=c;
                }else{
                    r[i+1]=d[i+1];
                    d[i+1]=r[i];
                }
            }
            r[0]=0;
        }
        return r[n];
    }
}