class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if (costBoth >= cost1 + cost2) {
            return (need1 * cost1) + (need2 * cost2);
        }
        long totalCost = 0;
        long commonNeed = Math.min(need1, need2);
        totalCost += commonNeed * costBoth;
        long rem1 = need1 - commonNeed;
        long rem2 = need2 - commonNeed;
        if (rem1 > 0) {
            totalCost += rem1 * Math.min(cost1, costBoth);
        } else if (rem2 > 0) {
            totalCost += rem2 * Math.min(cost2, costBoth);
        }
        return totalCost;
    }
}