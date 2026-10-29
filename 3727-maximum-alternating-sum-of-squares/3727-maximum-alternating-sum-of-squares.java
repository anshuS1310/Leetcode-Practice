class Solution {
    public long maxAlternatingSum(int[] nums) {
      int [] f= new int[40001];
      int n=nums.length,m=n>>1,mx=0;
      for(int i:nums){
        int v = i<0 ? -i:i;
        f[v]++;
        if(v>mx){
            mx=v;
        }
      }
      int c=0;
      long ans=0;
      for(int i=0;i<=mx;i++){
        int ct=f[i];
        if(ct==0){
            continue;
        }
        long sq=(long) i*i;
        f[i]=0;
        if(c<m){
            int ng=Math.min(ct,m-c);
            ans-=(long) ng*sq;
            c+=ng;
            ct-=ng;
        }
        if(ct>0){
            ans+=(long) ct*sq;
            c+=ct;
        }
      }
      return ans;
    }
}