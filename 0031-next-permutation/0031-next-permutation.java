class Solution {
    public void nextPermutation(int[] arr) {
        int n=arr.length;
        int p=-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                p=i;
                break;
            }
        }
        if(p==-1){
            rev(arr,0,n-1);
            return;
        }
        for(int i=n-1;i>p;i--){
            if(arr[i]>arr[p]){
                swap(arr,i,p);
                break;
            }
        }
        rev(arr,p+1,n-1);
    }
    static void rev(int []arr ,int l,int r){
        while(l<r) swap(arr,l++,r--);
    }
    static void swap(int []arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }

}