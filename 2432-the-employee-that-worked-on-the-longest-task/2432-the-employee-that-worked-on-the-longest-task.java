class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int ans=logs[0][0],chk=logs[0][1];
        for(int i=1;i<logs.length;i++){
            if(chk<=(logs[i][1]-logs[i-1][1])){
                if(chk==(logs[i][1]-logs[i-1][1])){
                    ans=Math.min(ans,logs[i][0]);
                }else{
                    chk=(logs[i][1]-logs[i-1][1]);
                    ans=logs[i][0];
                }
            }
        }
        return ans;
    }
}