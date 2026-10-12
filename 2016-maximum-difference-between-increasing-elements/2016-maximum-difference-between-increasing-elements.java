class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums[0];
        int d=-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>n){
                d=Math.max(d,nums[i]-n);
            }else{
                n=nums[i];
            }
        }
        return d;
    }
}