class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int openNeeded = 0; // Represents required ')' count

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                // Each '(' expects TWO ')' later
                openNeeded += 2;

                // If we needed an odd number of ')' before this '(',
                // it means a single ')' was left hanging. We must fix it!
                if (openNeeded % 2 != 0) {
                    insertions++;  // Insert one missing ')'
                    openNeeded--;  // Adjust remaining required ')'
                }
            } else { // c == ')'
                openNeeded--;

                // If openNeeded becomes negative, a ')' appeared without a '('
                if (openNeeded < 0) {
                    insertions++;  // Insert a missing '('
                    openNeeded += 2; // Now we expect 1 more ')' to complete the pair
                }
            }
        }

        // At the end, add any remaining required ')' to the result
        return insertions + openNeeded;
    }
}