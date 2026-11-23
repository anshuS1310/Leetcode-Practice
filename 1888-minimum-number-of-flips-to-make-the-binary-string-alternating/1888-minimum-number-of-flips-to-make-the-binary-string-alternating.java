class Solution {
    public int minFlips(String s) {
        if(s.length()%2==0){
            int f0=0,f1=0;
            boolean o=true;
            for(char c:s.toCharArray()){
                if(c=='0'^o){
                    f0++;
                }else{
                    f1++;
                }
                o=!o;
            }
            return Math.min(f1,f0);
        }else{
            int f0=0,f1=0,g0=1,g1=1;
            boolean o=true;
            for(char c:s.toCharArray()){
                if(c=='0'^o){
                    g0=Math.min(f0,g0);
                    g1=Math.min(g1,f1)+1;
                    f0++;
                }else{
                    g0=Math.min(f0,g0)+1;
                    g1=Math.min(g1,f1);
                    f1++;
                }
                o=!o;
            }
            return Math.min(Math.min(f1,g1),Math.min(f0,g0));
        }
    }
}