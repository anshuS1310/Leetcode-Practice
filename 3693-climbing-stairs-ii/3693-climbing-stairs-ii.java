class Solution {
    public int climbStairs(int n, int[] costs) {
        // dp[i] stores the minimum cost to reach step i
        int[] dp = new int[n + 1];
        
        // Base case: starting at step 0 costs 0
        dp[0] = 0;
        
        // Build the DP table bottom-up
        for (int i = 1; i <= n; i++) {
            int stepCost = costs[i - 1]; // Array is 0-indexed in Java
            
            // Jump of size 1: from step i - 1
            int minVal = dp[i - 1] + stepCost + 1; // 1^2 = 1
            
            // Jump of size 2: from step i - 2
            if (i >= 2) {
                minVal = Math.min(minVal, dp[i - 2] + stepCost + 4); // 2^2 = 4
            }
            
            // Jump of size 3: from step i - 3
            if (i >= 3) {
                minVal = Math.min(minVal, dp[i - 3] + stepCost + 9); // 3^2 = 9
            }
            
            dp[i] = minVal;
        }
        
        return dp[n];
    }
}