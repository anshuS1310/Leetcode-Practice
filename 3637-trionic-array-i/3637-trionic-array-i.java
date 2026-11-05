class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        int p=0,q=n-1;
        while(nums[p]<nums[p+1] && p<n-2){
            p++;
        }
        while(nums[q]>nums[q-1] && q>1){
            q--;
        }
        if(p>=q || q==n-1 || p==0){
            return false;
        }
        for(int i=p;i<q;i++){
            if(nums[i]<=nums[i+1]){
                return false;
            }
        }
        return true;     
    }
}