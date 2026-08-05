class Solution {
    public int maxSubArray(int[] nums) {
        int r=nums[0],mx=nums[0];
        for(int i=1;i<nums.length;i++){
            r=Math.max(r+nums[i],nums[i]);
            mx=Math.max(r,mx);
        }
        return mx;
    }
}