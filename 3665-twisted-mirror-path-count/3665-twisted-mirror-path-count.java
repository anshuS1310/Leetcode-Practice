class Solution {
    private static final int MOD = 1_000_000_007;
    public int uniquePaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m + 1][n + 1][2];

        // Base case: 1 valid path upon reaching destination (m-1, n-1)
        dp[m - 1][n - 1][0] = 1;
        dp[m - 1][n - 1][1] = 1;

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (r == m - 1 && c == n - 1) continue;

                if (grid[r][c] == 1) { 
                    // Mirror cell: forced turn (Right -> Down, Down -> Right)
                    dp[r][c][0] = dp[r + 1][c][1]; 
                    dp[r][c][1] = dp[r][c + 1][0]; 
                } else { 
                    // Empty cell: choices (Right path + Down path)
                    int paths = (dp[r][c + 1][0] + dp[r + 1][c][1]) % MOD;
                    dp[r][c][0] = paths;
                    dp[r][c][1] = paths;
                }
            }
        }

        // Sum paths starting at (0,0) going Right (c+1) and Down (r+1)
        return (dp[0][1][0] + dp[1][0][1]) % MOD;
    }
}