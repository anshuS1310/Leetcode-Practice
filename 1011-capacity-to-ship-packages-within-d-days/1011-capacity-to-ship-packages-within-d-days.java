import java.util.Arrays;
class Solution {
    private static boolean ck(int [] arr,int k,long p){
        int c=1;
        long ps=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]+ps>p){
                c++;
                ps=arr[i];
            }else{
                ps+=arr[i];
            }
        }
        return (c<=k);
    }
    public int shipWithinDays(int[] arr, int d) {
        long mnp=0,mxp=0;
        int res=-1;
        for(int i=0;i<arr.length;i++){
            mnp=Math.max(mnp,arr[i]);
            mxp+=arr[i];
        }
        while(mnp<=mxp){
            long m=mnp+(mxp-mnp)/2;
            if(ck(arr,d,m)){
                res=(int)m;
                mxp=m-1;
            }else{
                mnp=m+1;
            }
        }
        return res;
    }
}