class Solution {
    public int largestInteger(int[] nums, int k) {
        if(k==nums.length || k==1){
            int mx=0;
            for(int i:nums){
                mx=Math.max(i,mx);
            }
            if(k==1){
                int[] sub=new int[mx+1];
                int r=-1;
                for(int i:nums){
                    sub[i]+=1;
                }
                for(int i=0;i<sub.length;i++){
                    if(sub[i]==1){
                        r=i;
                    }
                }
                return r;
            }
            return mx;
        }else if(nums[0]==nums[nums.length-1]){
            return -1;
        }
        int s=0,l=0;
        for(int i:nums){
            if(nums[0]==i){
                s++;
            }else if(nums[nums.length-1]==i){
                l++;
            }
        }
        if(s==l){
            if(s==1){
                return nums[0]>nums[nums.length-1] ? nums[0] : nums[nums.length-1];
            }
            else return -1;
        }
        if(s==1){
            return nums[0];
        }else if(l==1){
            return nums[nums.length-1];
        }
        return -1;
    }
}