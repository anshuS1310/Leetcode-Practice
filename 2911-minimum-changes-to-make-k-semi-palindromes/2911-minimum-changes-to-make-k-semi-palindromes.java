import java.util.*;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();

        // 1. Precompute valid divisors d (1 <= d < len) for every length len
        List<Integer>[] divisors = new ArrayList[n + 1];
        for (int len = 2; len <= n; len++) {
            divisors[len] = new ArrayList<>();
            for (int d = 1; d < len; d++) {
                if (len % d == 0) {
                    divisors[len].add(d);
                }
            }
        }

        // 2. Stage 1: Precompute min changes cost[i][j] for every substring s[i..j]
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getSemiPalindromeCost(s, i, j, divisors[j - i + 1]);
            }
        }

        // 3. Stage 2: DP to partition s[0..end-1] into 'parts' substrings
        int INF = 1_000_000;
        int[][] dp = new int[k + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;

        for (int parts = 1; parts <= k; parts++) {
            // Each part has length >= 2, so 'end' must be at least 2 * parts
            for (int end = 2 * parts; end <= n; end++) {
                for (int split = 2 * (parts - 1); split <= end - 2; split++) {
                    if (dp[parts - 1][split] != INF) {
                        dp[parts][end] = Math.min(
                            dp[parts][end],
                            dp[parts - 1][split] + cost[split][end - 1]
                        );
                    }
                }
            }
        }

        return dp[k][n];
    }

    // Helper: Minimum letter changes to turn s[i..j] into a semi-palindrome
    private int getSemiPalindromeCost(String s, int i, int j, List<Integer> divs) {
        int minChanges = Integer.MAX_VALUE;

        for (int d : divs) {
            int changes = 0;
            // Check each of the d interleaved groups
            for (int offset = 0; offset < d; offset++) {
                int left = i + offset;
                int right = j - d + 1 + offset;
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        changes++;
                    }
                    left += d;
                    right -= d;
                }
            }
            minChanges = Math.min(minChanges, changes);
        }

        return minChanges;
    }
}