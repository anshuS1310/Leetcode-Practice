class Solution {
    private static int up(int [] nums,int target){
        int l=0,r=nums.length;
        while(l<r){
            int m=(l+r)/2;
            if(nums[m]<=target) l=m+1;
            else r=m;
        }
        return l;
    }
    private static int lb(int [] nums,int target){
        int l=0,r=nums.length;
        while(l<r){
            int m=(l+r)/2;
            if(nums[m]<target) l=m+1;
            else r=m;
        }
        return l;
    }
    public int[] searchRange(int[] nums, int target) {
        int a=lb(nums,target),b=up(nums,target);
        if (a == nums.length || nums[a] != target) {
        return new int[]{-1, -1};
        }
        b--;
        int res[]={a,b};
        return res;
    }
}