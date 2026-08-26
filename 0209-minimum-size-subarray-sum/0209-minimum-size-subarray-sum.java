class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans=Integer.MAX_VALUE;
        int sum=0;
        ArrayList<Integer> n=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            n.add(nums[i]);
            sum+=nums[i];
            while(sum>target){
                ans=Math.min(ans,n.size());
                sum-=n.get(0);
                n.remove(0);
            }
            if(sum==target){
                ans=Math.min(ans,n.size());
            } 
        }
        if(ans==Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }
}