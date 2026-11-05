class Solution {
    public boolean isTrionic(int[] nums) {
        int n=nums.length;
        int p=0,q=n-1;
        for(int i=0;i<n-2;i++){
            if(nums[i]>=nums[i+1]){
                p=i;
                break;
            }
        }
        if(p==0){
            return false;
        }
        for(int i=n-1;i>p;i--){
            if(nums[i]<=nums[i-1]){
                q=i;
                break;
            }
        }
        if(p>=q || q==n-1){
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