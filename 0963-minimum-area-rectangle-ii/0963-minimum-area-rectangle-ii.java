class Solution {
    private double ca(int i,int j, int k,int[][] p){
        int []f=p[i];
        int []s=p[j];
        int []t=p[k];
        return (double) Math.abs((f[0]*(s[1]-t[1]))+(s[0]*(t[1]-f[1]))+(t[0]*(f[1]-s[1])));
    }
    public double minAreaFreeRect(int[][] points) {
        double ans;
        double mna=Double.MAX_VALUE;
        int n=points.length;
        Map<Integer,Set<Integer>> m= new HashMap<>();
        for(int[] p:points){
            if(!m.containsKey(p[0])){
                m.put(p[0],new HashSet<>());
            }
            m.get(p[0]).add(p[1]);
        }
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int x1=points[j][0]-points[i][0];
                int y1=points[j][1]-points[i][1];
                for(int k=j+1;k<n;k++){
                    int x2=points[k][0]-points[i][0];
                    int y2=points[k][1]-points[i][1];
                    if((x1*x2 + y1*y2)!=0){
                        continue;
                    }
                    int x3=points[j][0]+x2;
                    int y3=points[j][1]+y2;
                    ans=ca(i,j,k,points);
                    if(ans>=mna){
                        continue;
                    }
                    if(m.get(x3)!=null && m.get(x3).contains(y3)){
                        mna=ans;
                    }
                }
            }
        }
        return mna==Double.MAX_VALUE ? 0.0 : mna;
    }
}