import java.util.Arrays;
class Solution {
    private static boolean isp(int [] arr, int k, int m){
        int j=1;
        int l=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-l>=m){
                j++;
                l=arr[i];
            }
            if(j==k){
                return true;
            }
        }
        return false;
    }
    public int maximumTastiness(int[] arr, int k) {
        Arrays.sort(arr);
        int l=0,r=arr[arr.length-1]-arr[0];
        int res=0;
        while(l<=r){
            int md=(l+r)/2;
            if(isp(arr,k,md)){
                res=md;
                l=md+1;
            }else{
                r=md-1;
            }
        }  
        return res;
    }
}