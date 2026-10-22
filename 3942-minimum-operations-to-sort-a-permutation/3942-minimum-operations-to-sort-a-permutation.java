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
        
        boolean isIncreasing = true;
        boolean isDecreasing = true;
        
        for (int i = 1; i < n; i++) {
            int prevIdx = (zero + i - 1) % n;
            int currIdx = (zero + i) % n;
            
            // FIXED: Added % n to wrap (n - 1) + 1 back to 0
            if (nums[currIdx] != (nums[prevIdx] + 1)) {
                isIncreasing = false;
            }
            if (nums[currIdx] != (nums[prevIdx] - 1 + n) % n) {
                isDecreasing = false;
            }
        }

        int ans = Integer.MAX_VALUE;

        if (isIncreasing) {
            ans = Math.min(ans, Math.min(zero, n - zero + 2));     
        }

        if (isDecreasing) {
            ans = Math.min(ans, Math.min(zero + 2, n - zero));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}