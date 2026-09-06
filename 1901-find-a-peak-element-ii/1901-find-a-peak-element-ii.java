class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int res[]=new int[2];
        int n=mat.length,c=mat[0].length;
        int l=0,r=c-1;
        int mn=-1000000000;
        while(l<=r){
            int m=(l+r)/2;
            int mx=0;
            for(int i=1;i<n;i++){
                if(mat[i][m]>mat[mx][m]){
                    mx=i;
                }
            }
            int lf= (m>0) ? mat[mx][m-1]:mn;
            int rg=(m+1<c) ? mat[mx][m+1]:mn;
            if(mat[mx][m]>=lf && mat[mx][m]>=rg){
                res[0]=mx;res[1]=m;
                return res;
            }
            else if(rg>mat[mx][m]){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        res[0]=-1;res[1]=-1;
        return res; 
    }
}