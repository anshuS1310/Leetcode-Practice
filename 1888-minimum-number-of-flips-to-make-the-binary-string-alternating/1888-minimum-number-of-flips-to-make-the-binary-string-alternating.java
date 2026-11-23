class Solution {
    public int minFlips(String s) {
        int n=s.length();
        int f1=0,f2=0;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<2*n;i++){
            char c1= i%2==0 ? '1' : '0';
            char c2= i%2==0 ? '0' : '1';
            if(s.charAt(i%n)==c1){
                f1++;
            }else{
                f2++;
            }
            if(i>=n){
                int l=n-i;
                char c11= l%2==0 ? '1':'0';
                char c22= l%2==0 ? '0':'1';
                if(s.charAt(i%n)==c11){
                    f1--;
                }else{
                    f2--;
                }
            }
            if (i>=n-1){
                res=Math.min(res,Math.min(f1,f2));
            }
        }
        return res;
    }
}