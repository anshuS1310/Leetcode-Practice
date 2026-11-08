class Solution {
    public int totalNumbers(int[] digits) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        int n = digits.length;

        // Permute indices i (units), j (tens), k (hundreds)
        for (int i = 0; i < n; i++) {
            // Units place must be even
            if (digits[i] % 2 != 0) continue;

            for (int j = 0; j < n; j++) {
                if (j == i) continue; // Cannot reuse index i

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue; // Cannot reuse index i or j
                    if (digits[k] == 0) continue;   // Hundreds place cannot be zero

                    // Form 3-digit number: hundreds*100 + tens*10 + units
                    int number = digits[k] * 100 + digits[j] * 10 + digits[i];
                    uniqueNumbers.add(number);
                }
            }
        }

        return uniqueNumbers.size();
    }
}