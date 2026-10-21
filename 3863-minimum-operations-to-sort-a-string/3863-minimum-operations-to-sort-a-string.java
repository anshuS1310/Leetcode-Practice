class Solution {
    public int minOperations(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;

        // Check if string is already sorted
        boolean isSorted = true;
        for (int i = 1; i < n; i++) {
            if (cs[i] < cs[i - 1]) {
                isSorted = false;
                break;
            }
        }
        if (isSorted) return 0;

        // Unsorted length 2 string cannot be fixed (no proper substring of length >= 2)
        if (n == 2) return -1;

        // Find global minimum and maximum characters
        char mn = cs[0], mx = cs[0];
        for (int i = 1; i < n; i++) {
            if (cs[i] < mn) mn = cs[i];
            if (cs[i] > mx) mx = cs[i];
        }

        // Case 1: Min already at start OR Max already at end -> 1 operation
        if (cs[0] == mn || cs[n - 1] == mx) {
            return 1;
        }

        // Case 2: Either Min or Max exists in the inner substring s[1...n-2] -> 2 operations
        for (int i = 1; i < n - 1; i++) {
            if (cs[i] == mn || cs[i] == mx) {
                return 2;
            }
        }

        // Case 3: Min only exists at the last index AND Max only exists at index 0 -> 3 operations
        return 3;
    }
}