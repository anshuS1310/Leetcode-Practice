class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        // 1. Your exact idea: prefix sum array of length n + 1
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        // 2. Fix: Start with Integer.MAX_VALUE since we want the MINIMUM positive sum
        int ans = Integer.MAX_VALUE;

        // 3. Your exact outer loop: try every subarray length from l to r
        for (int len = l; len <= r; len++) {
            // 4. Your exact inner loop: slide window of size `len` across prefix sum
            for (int i = len; i <= n; i++) {
                int currentSubarraySum = prefix[i] - prefix[i - len];

                // 5. Fix: Only consider strictly positive sums (> 0) and take Math.min
                if (currentSubarraySum > 0) {
                    ans = Math.min(ans, currentSubarraySum);
                }
            }
        }

        // 6. Your exact return pattern: if no positive sum was found, return -1
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}