class Solution {
    public int minMoves(int[] nums) {
        int moves = 0,min=nums[0];     
        for(int i:nums){
            if(i<min){
                min=i;
            }
        }
        for(int i:nums){
            moves+=(i-min);
        }
        return moves;
    }
}