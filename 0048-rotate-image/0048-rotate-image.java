class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<(matrix.length)/2;i++){
            int t[]=matrix[i];
            matrix[i]=matrix[matrix.length-i-1];
            matrix[matrix.length - i-1]=t;   
        }
        for(int i=0;i<=matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int t=matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=t;
            }
        }
    }
        
}