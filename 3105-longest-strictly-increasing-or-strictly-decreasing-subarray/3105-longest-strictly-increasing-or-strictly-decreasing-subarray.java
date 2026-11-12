class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ci=1,cd=1,ans=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                ci++;
                cd=1;
            }else if(nums[i]<nums[i-1]){
                cd++;
                ci=1;
            }else{
                ci=1;
                cd=1;
            }
            ans=Math.max(ans,Math.max(cd,ci));
        }
        return ans;
    }
}