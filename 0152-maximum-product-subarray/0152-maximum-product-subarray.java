class Solution {
    public int maxProduct(int[] nums) {
        int m=Integer.MIN_VALUE,l=1,r=1;
        for(int i=0;i<nums.length;i++){
            if(l==0) l=1;
            if(r==0) r=1;
            l*=nums[i];
            r*=nums[(nums.length)-i-1];
            m=Math.max(l,Math.max(r,m));
        }
        return m;
    }
}