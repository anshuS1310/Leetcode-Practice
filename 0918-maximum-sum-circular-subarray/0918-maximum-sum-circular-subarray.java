class Solution {
    public int maxSubarraySumCircular(int[] n) {
        int cmx=0,cmn=0;
        int mx=n[0],mn=n[0];
        int t=0;
        for(int i=0;i<n.length;i++){
            cmx=Math.max(n[i],n[i]+cmx);
            mx=Math.max(cmx,mx);
            cmn=Math.min(n[i],n[i]+cmn);
            mn=Math.min(cmn,mn);
            t+=n[i];
        }
        int cis=t-mn;
        if(cis==0){
            return mx;
        }
        return Math.max(mx,cis);
    }
}