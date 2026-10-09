class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n=nums.length;
        int pr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            pr[i][0]=nums[i];
            pr[i][1]=i;
        }
        Arrays.sort(pr,(a,b)->Integer.compare(b[0],a[0]));
        Arrays.sort(pr,0,k,(a,b)->Integer.compare(a[1],b[1]));
        int res[] = new int[k];
        for(int i=0;i<k;i++){
            res[i]=pr[i][0];
        }
        return res;
    }
}