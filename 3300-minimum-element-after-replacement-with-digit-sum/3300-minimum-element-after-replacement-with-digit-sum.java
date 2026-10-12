class Solution {
    private int sm(int n){
        int res=0;
        while(n>0){
            res+=n%10;
            n/=10;
        }
        return res;
    }
    public int minElement(int[] nums) {
        int mn=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            mn=Math.min(sm(nums[i]),mn);
        }
        return mn;
    }
}