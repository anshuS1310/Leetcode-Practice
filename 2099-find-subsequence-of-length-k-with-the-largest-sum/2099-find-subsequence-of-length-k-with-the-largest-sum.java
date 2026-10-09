class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // 1. Find top k elements by sorting a clone
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        // 2. Build frequency map for only the top k largest values
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = sorted.length - k; i < sorted.length; i++) {
            counts.put(sorted[i], counts.getOrDefault(sorted[i], 0) + 1);
        }

        // 3. Collect elements in original array order
        int[] res = new int[k];
        int idx = 0;
        for (int num : nums) {
            if (counts.getOrDefault(num, 0) > 0) {
                res[idx++] = num;
                counts.put(num, counts.get(num) - 1); // Decrement count
            }
        }

        return res;
    }
}