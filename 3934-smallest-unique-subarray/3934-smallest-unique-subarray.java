class Solution {
    private static final long BASE1 = 100003L, MOD1 = 1_000_000_007L;
    private static final long BASE2 = 100019L, MOD2 = 1_000_000_009L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;

        // Precompute powers for O(1) window sliding
        long[] pow1 = new long[n + 1];
        long[] pow2 = new long[n + 1];
        pow1[0] = 1;
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow1[i] = (pow1[i - 1] * BASE1) % MOD1;
            pow2[i] = (pow2[i - 1] * BASE2) % MOD2;
        }

        // Change 1: Binary search on window length instead of 1..n
        int low = 1, high = n, ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (hasUniqueSubarray(nums, mid, pow1, pow2)) {
                ans = mid;
                high = mid - 1; // Try to find an even smaller length
            } else {
                low = mid + 1;  // Need a longer window
            }
        }
        return ans;
    }

    // Your exact HashMap + frequency == 1 check, upgraded with O(1) rolling hash
    private boolean hasUniqueSubarray(int[] nums, int len, long[] pow1, long[] pow2) {
        Map<Long, Integer> freqMap = new HashMap<>();
        long h1 = 0, h2 = 0;

        // Build hash for the first window [0 .. len - 1]
        for (int i = 0; i < len; i++) {
            h1 = (h1 * BASE1 + nums[i]) % MOD1;
            h2 = (h2 * BASE2 + nums[i]) % MOD2;
        }
        freqMap.put((h1 << 32) | h2, 1);

        // Slide the window across the rest of the array in O(1) per step
        for (int i = len; i < nums.length; i++) {
            int out = nums[i - len];
            int in = nums[i];

            h1 = (h1 - (out * pow1[len - 1]) % MOD1 + MOD1) % MOD1;
            h1 = (h1 * BASE1 + in) % MOD1;

            h2 = (h2 - (out * pow2[len - 1]) % MOD2 + MOD2) % MOD2;
            h2 = (h2 * BASE2 + in) % MOD2;

            long key = (h1 << 32) | h2;
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        }

        // Same check as your intuition: is any frequency equal to 1?
        for (int count : freqMap.values()) {
            if (count == 1) {
                return true;
            }
        }
        return false;
    }
}