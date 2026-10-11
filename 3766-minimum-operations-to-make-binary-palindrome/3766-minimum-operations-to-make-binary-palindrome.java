class Solution {
    private boolean chkp(int n) {
        int r = 0, t = n;
        while (t > 0) {
            r = (r << 1) | (t & 1);
            t >>= 1;
        }
        return r == n;
    }
    private int minr(int n) {
        int i = n, j = n;
        while (true) {
            if (i > 0 && chkp(i)) {
                return i - n;
            }
            if (j > 0 && chkp(j)) {
                return n - j;
            }
            i++;
            j--;
        }
    }
    public int[] minOperations(int[] nums) {
        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = minr(nums[i]);
        }
        return res;
    }
}