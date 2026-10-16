class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int mx=0,c=0;
        for(int num:nums){
            if(num==1){
                c++;
            }else{
                mx=Math.max(mx,c);
                c=0;
            }
        }
        return Math.max(c,mx);
    }
}