class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
            for(int j=i;j<=n;j++){
                int s=prefix[j]-prefix[j-i];
                if(s>0){
                    ans=Math.min(ans,s);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}