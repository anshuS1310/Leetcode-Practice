class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2; // Combined budget (use long to prevent overflow!)
        int n = nums1.length;

        int maxDiff = 0;
        long totalDiff = 0;
        // Since 0 <= nums1[i], nums2[i] <= 10^5, max possible difference is 100000
        int[] count = new int[100001];

        // Step 1: Compute all differences and count how many times each diff appears
        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            count[d]++;
            totalDiff += d;
            maxDiff = Math.max(maxDiff, d);
        }

        // Edge Case: If k is enough to reduce EVERY difference all the way to 0
        if (totalDiff <= k) {
            return 0;
        }

        // Step 2: Your intuition — start from the biggest diff and flatten downward
        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (count[d] == 0) continue;

            if (k >= count[d]) {
                // We have enough moves to drop ALL elements at level 'd' down to 'd - 1'
                k -= count[d];
                count[d - 1] += count[d];
                count[d] = 0;
            } else {
                // Not enough moves for all of them: drop 'k' of them to 'd - 1',
                // and leave the remaining (count[d] - k) elements at 'd'
                count[d - 1] += (int) k;
                count[d] -= (int) k;
                k = 0;
            }
        }

        // Step 3: Sum up (d^2 * how many elements have difference d)
        long ans = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (count[d] > 0) {
                ans += (long) d * d * count[d];
            }
        }

        return ans;
    }
}