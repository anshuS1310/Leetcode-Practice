import java.util.*;
class Solution {
    private static boolean ck(int [] arr,int k,int m){
        long rq=0;
        for(int i=0;i<arr.length;i++){
            rq+=(arr[i]+m-1)/m;
        }
        return rq<=k;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int km=Integer.MIN_VALUE,kn=1;
        int n=piles.length,res=km;
        for(int i:piles){
            km=Math.max(km,i);
        }
        while(kn<=km){
            int m=kn+(km-kn)/2;
            if(ck(piles,h,m)){
                res=m;
                km=m-1;
            }else{
                kn=m+1;
            }
        }
        return res;
    }
}