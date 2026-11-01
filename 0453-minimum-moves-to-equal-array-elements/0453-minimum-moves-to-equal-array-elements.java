class Solution {
    public int minMoves(int[] nums) {
        int moves = 0,min=nums[0];     
        for(int i:nums){
            if(i<min){
                min=i;
            }
            moves+=i;
        }
        moves-=(min*nums.length);
        return moves;
    }
}