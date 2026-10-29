class Solution {
    public long maxAlternatingSum(int[] nums) {
      int n = nums.length, a = n >> 1, max = 0;   
        for (int x : nums) max = Math.max(max, Math.abs(x));
        int[] f = new int[max + 1];
        for (int x : nums) f[Math.abs(x)]++;

        long ans = 0;
        int c = 0;                                
        for (int i = 0; i <= max; i++) {
            int count = f[i];
            if (count == 0) continue;
            long sq = (long) i * i;
            if (c < a) {                          
                int pos = Math.min(count, a - c);
                ans -= (long) pos * sq;
                c += pos;
                count -= pos;
            }
            if (count > 0) {                      
                ans += (long) count * sq;
                c += count;
            }
        }
        return ans;
    }
}