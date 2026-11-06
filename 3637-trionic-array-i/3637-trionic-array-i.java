class Solution {
    public boolean isTrionic(int[] nums) {
        int p = 0;
        int q = nums.length - 1;
        while (nums[p] < nums[p + 1] && p < nums.length - 2) {
            p++;
        }
        while (nums[q] > nums[q - 1] && q > 1) {
            q--;
        }
        if (p == 0 || q == nums.length - 1 || p >= q) 
            return false;
        
        for (int i = p; i < q; i++) {
            if (nums[i] <= nums[i + 1])
                return false;
        }

        return true;  
    }
}