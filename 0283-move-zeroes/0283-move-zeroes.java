class Solution {
    public void moveZeroes(int[] arr) {
       int c=0;
       for(int i=0;i<arr.length;i++){
        if(arr[i]!=0){
            int t=arr[c];
            arr[c]=arr[i];
            arr[i]=t;
            c++;
        }
       } 
    }
}