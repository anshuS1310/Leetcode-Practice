class Solution {
    public int divide(int dvd, int dvs) {
        if(dvd==Integer.MIN_VALUE && dvs==-1){
            return Integer.MAX_VALUE;
        }
        boolean neg=(dvd<0)^(dvs<0);
        long a=Math.abs((long) dvd);
        long b=Math.abs((long) dvs);
        long r=0;
        while(a>=b){
            long t=b;
            long m=1;
            while(a>=(t<<1)){
                t=t<<1;
                m=m<<1;
            }
            a-=t;
            r+=m;
        }
        if(neg){
            r=-r;
        }
        return (int) r;
    }
}