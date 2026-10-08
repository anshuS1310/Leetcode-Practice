class Solution {
    private int ct(int n){
        int c=0;
        while(n!=0){
            c+=(n&1);
            n>>=1;
        }
        return c;
    }
    public int[] countBits(int n) {
        int [] res=new int[n+1];
        for(int i=0;i<=n;i++){
            res[i]=ct(i);
        }
        return res;
    }
}