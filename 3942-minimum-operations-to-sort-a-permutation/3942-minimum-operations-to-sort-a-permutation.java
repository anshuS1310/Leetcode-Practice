class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        
        // Find index of 0
        int zero = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero = i;
                break;
            }
        }
        
        // Helper to check relative ordering starting from 'zero'
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        
        for (int i = 1; i < n; i++) {
            int prevIdx = (zero + (i - 1)) % n;
            int currIdx = (zero + i) % n;
            
            if (nums[currIdx] != (nums[prevIdx] + 1)) {
                isIncreasing = false;
            }
            if (nums[currIdx] != (nums[prevIdx] - 1 + n) % n) {
                isDecreasing = false;
            }
        }

        int ans = Integer.MAX_VALUE;

        if (isIncreasing) {
            ans = Math.min(ans, zero);              // Just rotate left
            ans = Math.min(ans, n - zero + 2);      // Reverse, rotate, reverse back
        }

        if (isDecreasing) {
            ans = Math.min(ans, zero + 2);          // Rotate left, reverse
            ans = Math.min(ans, n - zero);          // Reverse, rotate left
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}