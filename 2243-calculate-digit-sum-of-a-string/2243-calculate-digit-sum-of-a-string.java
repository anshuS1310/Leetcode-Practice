class Solution {
    public String digitSum(String s, int k) {
        String res = s;

        // Keep repeating rounds until the string length is less than or equal to k
        while (res.length() > k) {
            List<String> list = new ArrayList<>();
            String current = "";

            // 1. Divide 'res' into chunks of size k using your char-by-char loop
            for (int i = 0; i < res.length(); i++) {
                current += res.charAt(i);
                if (current.length() == k) {
                    list.add(current);
                    current = "";
                }
            }
            // Add any leftover characters if length wasn't a multiple of k
            if (!current.isEmpty()) {
                list.add(current);
            }

            // 2. Call your helper function to sum each chunk's digits and rebuild 'res'
            res = sumChunks(list);
        }

        return res;
    }

    // Helper function that takes the ArrayList of chunks, replaces each with its digit sum,
    // and concatenates them into the new string
    private String sumChunks(List<String> list) {
        String ans = "";

        for (int i = 0; i < list.size(); i++) {
            String chunk = list.get(i);
            int digitSum = 0;

            // Sum individual characters instead of Integer.parseInt() so k=100 never overflows
            for (int j = 0; j < chunk.length(); j++) {
                digitSum += chunk.charAt(j) - '0';
            }

            String sumStr = String.valueOf(digitSum);
            list.set(i, sumStr); // Replace element in the list as you described
            ans += sumStr;       // Concatenate into the new result string
        }

        return ans;
    }
}