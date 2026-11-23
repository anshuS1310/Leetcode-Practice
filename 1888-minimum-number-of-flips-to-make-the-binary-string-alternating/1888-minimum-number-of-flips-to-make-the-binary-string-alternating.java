class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int res = Integer.MAX_VALUE;
        int f1 = 0, f2 = 0;
        for (int i = 0; i < 2 * n; i++) {
            char c1 = (i % 2 == 0) ? '0' : '1';
            char c2 = (i % 2 == 0) ? '1' : '0';
            if (s.charAt(i % n) != c1) f1++;
            else if (s.charAt(i % n) != c2) f2++;
            if (i >= n) {
                int left = i - n;
                char leftC1 = (left % 2 == 0) ? '0' : '1';
                char leftC2 = (left % 2 == 0) ? '1' : '0';
                if (s.charAt(left) != leftC1) f1--;
                else if (s.charAt(left) != leftC2) f2--;
            }
            if (i >= n - 1) {
                res = Math.min(res, Math.min(f1, f2));
            }
        }
        return res;
        
    }
}