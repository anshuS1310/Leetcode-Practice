class Solution {
    private static long carc(long md,int rk){
        return (long)(Math.sqrt(md/rk));
    }
    private static boolean chk(int []r,int cr,long md){
        long t=0;
        for(int i:r){
            t+=carc(md,i);
            if(t>=cr){
                return true;
            }
        }
        return false;
    }
    public long repairCars(int[] ranks, int cars) {
        int rm=ranks[0];
        for(int i=1;i<ranks.length;i++){
            rm=Math.min(rm,ranks[i]);
        }
        long l=0,h=(long)rm*cars*cars;
        long ans=h;
        while(l<=h){
            long md=l+(h-l)/2;
            if(chk(ranks,cars,md)){
                ans=md;
                h=md-1;
            }else{
                l=md+1;
            }
        }
        return ans;
    }
}