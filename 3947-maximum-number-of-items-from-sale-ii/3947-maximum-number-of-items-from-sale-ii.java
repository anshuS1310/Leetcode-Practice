class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int mnp=Integer.MAX_VALUE;
        int mxf=0;
        for(int i[]:items){
            mxf=Math.max(mxf,i[0]);
            mnp=Math.min(mnp,i[1]);
        }
        int []fact=new int[mxf+1];
        for(int i[]:items){
            fact[i[0]]++;
        }
        int []mul=new int[mxf+1];
        Arrays.sort(items,(a,b)-> Integer.compare(a[1],b[1]));
        long r=budget;
        long ans=0;
        for(int i[]:items){
            int ft=i[0],prc=i[1];
            if (prc >= 2L * mnp || r < prc) break;
            if(mul[ft]==0){
                for(int j=ft;j<=mxf;j+=ft){
                    mul[ft]+=fact[j];
                }
            }
            int fl=mul[ft]-1;
            if(fl>0){
                long t=Math.min(fl,r/prc);
                r-=t*prc;
                ans+=2*t;
            }
        }
        ans+=r/mnp;
        return (int) ans;
    }
}