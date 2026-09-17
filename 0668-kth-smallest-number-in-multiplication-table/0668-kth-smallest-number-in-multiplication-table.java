class Solution {
    private static int ct(int md,int m ,int n){
        int c=0;
        for(int i=1;i<=m;i++){
            c+=Math.min(md/i,n);
        }
        return c;
    }
    public int findKthNumber(int m, int n, int k) {
        int l=0,r=m*n;
        while(l<r){
            int md=(l+r)/2;
            if(ct(md,m,n)<k){
                l=md+1;
            }else{
                r=md;
            }
        }
        return l;
    }
}