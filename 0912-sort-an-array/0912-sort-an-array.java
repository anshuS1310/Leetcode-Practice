class Solution {
    public int[] sortArray(int[] nums) {
        int mx=Integer.MIN_VALUE,mn=Integer.MAX_VALUE;
        for(int i:nums){
            mx=Math.max(i,mx);
            mn=Math.min(i,mn);
        }
        int [] c = new int[mx-mn+1];
        for(int i=0;i<nums.length;i++){
            c[nums[i]-mn]++;
        }
        for(int i=1;i<=mx-mn;i++){
            c[i]+=c[i-1];
        }
        int [] ans = new int [nums.length];
        for(int i=0;i<nums.length;i++){
            ans[c[nums[i]-mn]-1]=nums[i];
            c[nums[i]-mn]--;
        }
        return ans;  
    }
}