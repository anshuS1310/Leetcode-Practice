class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int maxFactor = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int[] p : items) {
            maxFactor = Math.max(maxFactor, p[0]);
            minPrice = Math.min(minPrice, p[1]);
        }

        int[] cntFactor = new int[maxFactor + 1];
        for (int[] p : items) {
            cntFactor[p[0]]++;
        }
        int[] cntMulti = new int[maxFactor + 1];

        // Change 1: Sort by price ascending instead of O(budget) DP
        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        long rem = budget;
        long ans = 0;

        // Change 2: Buy up to (cntMulti[factor] - 1) copies only while price < 2 * minPrice
        for (int[] p : items) {
            int factor = p[0], price = p[1];
            if (price >= 2L * minPrice || rem < price) {
                break;
            }

            if (cntMulti[factor] == 0) {
                for (int j = factor; j <= maxFactor; j += factor) {
                    cntMulti[factor] += cntFactor[j];
                }
            }

            int freeLimit = cntMulti[factor] - 1;
            if (freeLimit > 0) {
                long take = Math.min(freeLimit, rem / price);
                rem -= take * price;
                ans += 2 * take;
            }
        }

        // Same final step as 0x3f: spend leftover budget on minPrice
        ans += rem / minPrice;
        return (int) ans;
    }
}