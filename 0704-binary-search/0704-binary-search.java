class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length-1;
        int n1=0;
        while(n1<=n){
            int m=n1+(n-n1)/2;
            if(nums[m]==target){
                return m;
            }else if(nums[m]>target){
                n=m-1;
            }else{
                n1=m+1;
            }
        }
        return -1;
    }
}