class Solution {
    public int minMoves(int[] nums) {
        int mx=0,res=0;
        for(int i:nums){
            mx=Math.max(i,mx);
            res+=i;
        }
        return (mx*nums.length)-res;
    }
}