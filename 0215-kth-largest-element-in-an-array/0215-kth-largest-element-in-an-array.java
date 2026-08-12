class Solution {
    public int findKthLargest(int[] nums, int k) {
        int mx = nums[0];
        int[] count = new int[20001];

        for(int i = 0; i < nums.length; i++) {
            mx = Math.max(mx, nums[i]);
            count[nums[i] + 10000]++;
        }

        int a = 0;
        while(a < k) {
            a += count[mx + 10000];
            if (a >= k) return mx;
            mx--;
        }
        return mx + 1;
    }
}