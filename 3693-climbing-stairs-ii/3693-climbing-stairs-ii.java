class Solution {
    public int climbStairs(int n, int[] costs) {
        if(n == 1) return costs[0] + 1;
        int tb=0,sb=costs[0]+1;
        int fb=costs[1]+Math.min(sb+1,4);
        int rs=fb;
        for(int i=3;i<=n;i++){
            int fs=fb+1,ss=sb+4,ts=tb+9;
            rs=costs[i-1]+Math.min(fs,Math.min(ss,ts));
            tb=sb;
            sb=fb;
            fb=rs;
        }
        return rs;
    }
}