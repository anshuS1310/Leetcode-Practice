class Solution {
    public int search(int[] nums, int x) {
        int l=0,r=nums.length-1;
        while(l<=r){
            int m=l+(r-l)/2;
            if(nums[m]==x){
                return m;
            }
            if(nums[m]>=nums[l]){
                if(x>=nums[l] && x<nums[m]){
                    r=m-1;
                }else{
                    l=m+1;
                }
            }else{
                if(x>nums[m]&&x<=nums[r]){
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
        }
        return -1;    
    }
}