class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007,s=0;
        long co = 0;
        for (int i = 0; i < arr.length; i++) {
            s+=arr[i];
            co+=s%2;
        }     
        return (int) (co +(co * (arr.length-co)) % MOD);
    }
}