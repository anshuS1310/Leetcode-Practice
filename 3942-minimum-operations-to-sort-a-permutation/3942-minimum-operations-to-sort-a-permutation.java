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
            
            if (nums[currIdx] != (nums[prevIdx] + 1)%n) {
                isIncreasing = false;
            }
            if (nums[currIdx] != (nums[prevIdx] - 1 + n) % n) {
                isDecreasing = false;
            }
        }

        int ans = Integer.MAX_VALUE;

        if (isIncreasing) {
            ans = Math.min(zero, n - zero + 2);     
        }

        else if (isDecreasing) {
            ans = Math.min(zero+2, n - zero);          // Reverse, rotate left
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}