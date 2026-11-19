class Solution {
    public int minimizeSum(int[] nums) {
        int mn1=Integer.MAX_VALUE,mn2=Integer.MAX_VALUE,mn3=Integer.MAX_VALUE;
        int mx1=Integer.MIN_VALUE,mx2=Integer.MIN_VALUE,mx3=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>mx3){
                if(nums[i]>mx2){
                    if(nums[i]>mx1){
                        mx3=mx2;
                        mx2=mx1;
                        mx1=nums[i];
                    }else{
                        mx3=mx2;
                        mx2=nums[i];
                    }
                }else{
                    mx3=nums[i];
                }
            }
            if(nums[i]<mn3){
                if(nums[i]<mn2){
                    if(nums[i]<mn1){
                        mn3=mn2;
                        mn2=mn1;
                        mn1=nums[i];
                    }else{
                        mn3=mn2;
                        mn2=nums[i];
                    }
                }else{
                    mn3=nums[i];
                }
            }
        }
        return Math.min(mx3-mn1,Math.min(mx2-mn2,mx1-mn3));
    }
}