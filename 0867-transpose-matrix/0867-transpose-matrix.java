class Solution {
    public int[][] transpose(int[][] m) {
        int[][] m1=new int[m[0].length][m.length];
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                m1[j][i]=m[i][j];
            }
        }
        return m1;
    }
}