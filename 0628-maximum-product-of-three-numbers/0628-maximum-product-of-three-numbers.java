class Solution {
    public int maximumProduct(int[] nums) {
        
        int mx1=Integer.MIN_VALUE,mx2=Integer.MIN_VALUE,mx3=Integer.MIN_VALUE;
        int mn1=0,mn2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0 && nums[i]>mx1){
                mx3=mx2;
                mx2=mx1;
                mx1=nums[i];
            }else if(nums[i]>=0 && nums[i]>mx2){
                mx3=mx2;
                mx2=nums[i];
            }else if(nums[i]>=0 && nums[i]>mx3){
                mx3=nums[i];
            }
            if(nums[i]<0 && nums[i]<mn1){
                mn2=mn1;
                mn1=nums[i];
            }else if(nums[i]<0 && nums[i]<mn2){
                mn2=nums[i];
            }
        }
        int min1=Integer.MIN_VALUE,min2=Integer.MIN_VALUE,min3=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0 && nums[i]>min1){
                min3=min2;
                min2=min1;
                min1=nums[i];
            }else if(nums[i]<0 && nums[i]>min2){
                min3=min2;
                min2=nums[i];
            }else if(nums[i]<0 && nums[i]>min3){
                min3=nums[i];
            }
        }
        if(nums.length==3){
            return (nums[0]*nums[1]*nums[2]);
        }else if(mx1==Integer.MIN_VALUE){
            return min1*min2*min3;
        }else{
            return mx1*mx2*mx3> mx1*mn1*mn2 ? mx1*mx2*mx3 : mx1*mn1*mn2;
        }
    }
}