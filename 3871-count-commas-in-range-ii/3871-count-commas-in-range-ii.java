class Solution {
    public long countCommas(long n) {
        if(n<1000) return 0;
        long num=0;
        for(long i=1000;i<=n;i*=1000){
            num=num+n-i+1;
        }
        return num;  
    }
}