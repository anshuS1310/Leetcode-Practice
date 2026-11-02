class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int m=((nums.length+1)/2)-1;
        int res=0;
        for(int i:nums){
            res+=Math.abs(nums[m]-i);
        }
        return res;
    }
}