class Solution {
    public int firstStableIndex(int[] nums, int k) {
        if(nums.length==0){
            return -1;
        }
        int sfmn=Integer.MAX_VALUE,pfmx=Integer.MIN_VALUE;
        int[] sf=new int [nums.length];
        for(int i=nums.length-1;i>=0;i--){
            sfmn=Math.min(sfmn,nums[i]);
            sf[i]=sfmn;
        }
        int res=-1;
        for(int i=0;i<nums.length;i++){
            pfmx=Math.max(pfmx,nums[i]);
            if((pfmx-sf[i])<=k){
                return i;
            }
        }
        return res;
    }
}