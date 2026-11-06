class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs,(a,b)->Integer.compare(a[1],b[1]));
        Integer [] o=new Integer[queries.length];
        for(int i=0;i<queries.length;i++){
            o[i]=i;
        }
        Arrays.sort(o,(a,b)->Integer.compare(queries[a],queries[b]));
        int sc[]=new int[n+1];
        int ac=0,l=0,r=0;
        int ans[]=new int[queries.length];
        for(int i:o){
            while(r<logs.length && logs[r][1]<=queries[i]){
                if(sc[logs[r][0]]++==0){
                    ac++;
                }
                r++;
            }
            while(l<r && logs[l][1]<queries[i]-x){
                if(--sc[logs[l][0]]==0){
                    ac--;
                }
                l++;
            }
            ans[i]=n-ac;
        }
        return ans;

    }
}