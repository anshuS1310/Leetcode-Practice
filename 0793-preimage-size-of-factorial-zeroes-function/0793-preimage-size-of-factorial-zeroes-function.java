class Solution {
    static long chk(long a){
        long c=0;
        while(a>0){
            c+=a/5;
            a/=5;
        }
        return c;

    }
    public int preimageSizeFZF(int k) {
        long l=0,r=5L*k;
        while(l<r){
            long m=l+(r-l)/2;
            if(chk(m)>=k){
                r=m;
            }else{
                l=m+1;
            }
        }
        return chk(l)==k ? 5 : 0;
    }
}