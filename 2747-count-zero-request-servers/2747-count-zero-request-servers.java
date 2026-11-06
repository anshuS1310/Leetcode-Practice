class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int st[][]=new int [queries.length][2];
        for(int i=0;i<queries.length;i++){
            st[i][0]=queries[i];
            st[i][1]=i;
        }
        Arrays.sort(logs,(a,b)-> Integer.compare(a[1],b[1]));
        Arrays.sort(st,(a,b)-> Integer.compare(a[0],b[0]));
        int []sc=new int[n+1];
        int r=0,l=0,as=0;
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int its=st[i][0]-x;
            int ite=st[i][0];
            while(r<logs.length && logs[r][1]<=ite){
                int sid=logs[r][0];
                if(sc[sid]==0){
                    as++;
                }
                sc[sid]++;
                r++;
            }
            while(l<logs.length && logs[l][1]<its){
                int sid=logs[l][0];
                sc[sid]--;
                if(sc[sid]==0){
                    as--;
                }
                l++;
            }
            ans[st[i][1]]=n-as;
        }
        return ans;
    }
}