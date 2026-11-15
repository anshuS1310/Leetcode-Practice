class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        int[] p = new int[arr.length + 1];
        p[0] = 0;
        long co = 0, ce = 1;
        for (int i = 0; i < arr.length; i++) {
            p[i + 1] = arr[i] + p[i];
            if (p[i + 1] % 2 == 0) {
                ce++;
            } else {
                co++;
            }
        }     
        return (int) ((co * ce) % MOD);
    }
}