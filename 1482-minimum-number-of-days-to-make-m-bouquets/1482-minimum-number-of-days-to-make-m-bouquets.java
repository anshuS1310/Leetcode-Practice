class Solution {
    private static boolean chk(int [] ar,int m,int k,int d){
        int bq=0,c=0;
        for(int i=0;i<ar.length;i++){
            if(ar[i]<=d){
                c++;
            }else{
                bq+=c/k;
                c=0;
            }
        }
        bq+=c/k;
        return bq>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int mn=0,mx=Integer.MIN_VALUE,res=-1;
        for(int i:bloomDay){
            mx=Math.max(i,mx);
        }
        while(mn<=mx){
            int md=(mn+mx)/2;
            if(chk(bloomDay,m,k,md)){
                res=md;
                mx=md-1;
            }else{
                mn=md+1;
            }
        }
        return res;
    }
}