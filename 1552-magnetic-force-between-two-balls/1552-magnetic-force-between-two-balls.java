import java.util.Arrays;
class Solution {
    private static boolean isp(int[] arr,int k,int m){
        int c=1,l=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-l>=m){
                c++;
                l=arr[i];
            }
            if(c==k){
                return true;
            }
        }
        return false;
    }
    public int maxDistance(int[] arr, int m) {
        Arrays.sort(arr);
        int l=0,r=arr[arr.length-1]-arr[0],rs=1;
        while(l<=r){
            int md=l+(r-l)/2;
            if(isp(arr,m,md)){
                rs=md;
                l=md+1;
            }else{
                r=md-1;
            }
        }
        return rs;  
    }
}