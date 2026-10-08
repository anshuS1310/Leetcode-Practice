class Solution {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        int zeros = 0;
        while ((n & 1) == 0) {
            zeros++;
            n >>= 1;
        }
        return n == 1 && zeros % 2 == 0;
    }
}