class Solution {
    public int searchInsert(int[] arr, int k) {
      int l=0,r=arr.length-1;
      while(l<r){
        int m=l+(r-l)/2;
        if(arr[m]<k){
            l=m+1;
        }else{
            r=m;
        }
      }
      return arr[l]<k ? l+1:l;  
    }
}