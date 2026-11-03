class Solution {
    public int minMoves(int[] nums) {
        int mx=0;
        for(int i:nums){
            mx=Math.max(i,mx);
        }
        int res=0;
        for(int i:nums){
            res+=(mx-i);
        }
        return res;
    }
}