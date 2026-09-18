class Solution {
    private long cst(int[] nums,int cost[],int md){
        long res=0;
        for(int i=0;i<nums.length;i++){
            res+=(long)cost[i]*Math.abs(nums[i]-md);
        }
        return res;
    }
    public long minCost(int[] nums, int[] cost) {
        int mn=Integer.MAX_VALUE,mx=Integer.MIN_VALUE;
        for(int i:nums){
            mn=Math.min(i,mn);
            mx=Math.max(i,mx);
        }
        long ans=0;
        while(mn<=mx){
            int md=mn+(mx-mn)/2;
            long v1=cst(nums,cost,md-1),v2=cst(nums,cost,md),v3=cst(nums,cost,md+1);
            if(v1>=v2 && v2<=v3){
                ans=v2;
                break;
            }else if(v1>=v2 && v2>=v3){
                mn=md+1;
            }else if(v3>=v2 && v2>=v1){
                mx=md-1;
            }
        }
        return ans;     
    }
}