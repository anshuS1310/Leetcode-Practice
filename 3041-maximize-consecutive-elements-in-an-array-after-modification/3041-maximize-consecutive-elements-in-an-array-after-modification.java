class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        
        int maxLen = 1;
        int unshifted = 1; // streak ending at nums[i]
        int shifted = 1;   // streak ending at nums[i] + 1

        for (int i = 0; i < nums.length - 1; i++) {
            int curr = nums[i];
            int next = nums[i + 1];

            if (curr == next) {
                // Duplicate element!
                // 'next' can become (curr + 1), extending the 'unshifted' streak ending at curr
                shifted = unshifted + 1;
                // ('unshifted' stays the same since we already have a streak ending at curr)
            } else if (curr + 1 == next) {
                // Consecutive element (e.g., 2 -> 3)!
                // 'next' (3) extends 'unshifted' (ending at 2)
                // 'next + 1' (4) extends 'shifted' (ending at 3)
                unshifted = unshifted + 1;
                shifted = shifted + 1;
            } else if (curr + 2 == next) {
                // Gap of 1 (e.g., 2 -> 4)!
                // 'curr' shifted to (3), so 'next' (4) connects right onto 'shifted'!
                unshifted = shifted + 1;
                shifted = 1; // 4+1=5 starts a brand new streak
            } else {
                // Gap > 2 (e.g., 2 -> 6): streak completely breaks
                unshifted = 1;
                shifted = 1;
            }

            maxLen = Math.max(maxLen, Math.max(unshifted, shifted));
        }

        return maxLen;
    }
}