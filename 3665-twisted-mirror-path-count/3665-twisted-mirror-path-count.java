class Solution {
    private static final int MOD = 1_000_000_007;
    public int uniquePaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1) return 1; // Fix for 1x1 grid

        int dp[][][] = new int[m][n][2];
        dp[m - 1][n - 1][1] = 1;
        dp[m - 1][n - 1][0] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) continue;

                if (grid[i][j] == 1) {
                    // FIX 1: Set both entry direction states properly
                    dp[i][j][0] = (i + 1 < m) ? dp[i + 1][j][1] : 0; // Right -> Down
                    dp[i][j][1] = (j + 1 < n) ? dp[i][j + 1][0] : 0; // Down -> Right
                } else {
                    long r = (j + 1 < n) ? dp[i][j + 1][0] : 0;
                    long l = (i + 1 < m) ? dp[i + 1][j][1] : 0;
                    int paths = (int) ((r + l) % MOD);
                    
                    dp[i][j][0] = paths;
                    dp[i][j][1] = paths;
                }
            }
        }

        // FIX 2: Query the actual first step destinations out of (0,0)
        long totalPaths = 0;
        if (n > 1) totalPaths = (totalPaths + dp[0][1][0]) % MOD;
        if (m > 1) totalPaths = (totalPaths + dp[1][0][1]) % MOD;

        return (int) totalPaths;
    }
}