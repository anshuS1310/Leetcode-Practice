class Solution {
    public void setZeroes(int[][] m) {
        int n1=m.length,n2=m[0].length;
        int c=1;
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                if(m[i][j]==0){
                    m[i][0]=0;
                    if(j==0){
                        c=0;
                    }else{
                        m[0][j]=0;
                    }
                }
            }
        }
        for(int i=1;i<n1;i++){
            for(int j=1;j<n2;j++){
                if(m[i][0]==0 || m[0][j]==0){
                    m[i][j]=0;
                }
            }
        }
        if(m[0][0]==0){
            for(int i=0;i<n2;i++){
                m[0][i]=0;
            }
        }
        if(c==0){
            for(int i=0;i<n1;i++){
                m[i][0]=0;
            }
        } 
    }
}