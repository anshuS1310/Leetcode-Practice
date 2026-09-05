class Solution {
    static boolean bns(int [] arr,int x){
        int l=0,r=arr.length-1;
        while(l<=r){
            int m=(l+r)/2;
            if(arr[m]==x)
                return true;
            if(arr[m]>x){
                r=m-1;
            }else{
                l=m+1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] mt, int x) {
        int n=mt.length;
        int l=0,r=n-1,rw=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(mt[m][0]==x){
                return true;
            }
            if(mt[m][0]<x){
                rw=m;
                l=m+1;
            }else{
                r=m-1;
            }
        }
        if(r==-1){
            return false;
        }
        return bns(mt[r],x);
    }
}