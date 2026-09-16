class Solution {
    private static int cse(int [][] mat,int md){
        int n=mat.length;
        int r=0,c=n-1,ct=0;
        while(r<n && c>=0){
            if(mat[r][c]<=md){
                ct+=(c+1);
                r++;
            }else{
                c--;
            }
        }
        return ct;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int r=matrix[0][0],c=matrix[n-1][n-1],ans=0;
        while(r<=c){
            int m=r+(c-r)/2;
            int ct=cse(matrix,m);
            if(ct<k){
                r=m+1;
            }else{
                ans=m;
                c=m-1;
            }
        }
        return ans;    
    }
}