class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=l;j<=r;j++){
                int k=i+j;
                if(k>n){
                    break;
                }
                int s=prefix[k]-prefix[i];
                if(s>0){
                    ans=Math.min(s,ans);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}