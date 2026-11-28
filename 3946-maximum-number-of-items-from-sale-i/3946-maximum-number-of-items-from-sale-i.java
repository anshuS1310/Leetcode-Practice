class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int mxf=0;
        int mnp=Integer.MAX_VALUE;
        for(int i=0;i<items.length;i++){
            mnp=Math.min(items[i][1],mnp);
            mxf=Math.max(items[i][0],mxf);
        }
        int[] fact=new int[mxf+1];
        for(int i=0;i<items.length;i++){
            fact[items[i][0]]++;
        }
        int[] multi=new int[mxf+1];
        int []f=new int[budget+1];
        int sp=0;
        for(int i=0;i<items.length;i++){
            int ft=items[i][0],prc=items[i][1];
            if(multi[ft]==0){
                for(int j=ft;j<=mxf;j+=ft){
                    multi[ft]+=fact[j];
                }
            }
            int c=multi[ft];
            sp=Math.min(budget,sp+prc);
            for(int j=sp;j>=prc;j--){
                f[j]=Math.max(f[j],f[j-prc]+c);
            }
        }
        int ans=0;
        for(int i=0;i<=budget;i++){
            ans=Math.max(ans,f[i]+(budget-i)/mnp);
        }
        return ans;
    }
}