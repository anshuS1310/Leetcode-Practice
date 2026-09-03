class Solution {
    public int secondHighest(String s) {
        int l=-1;
        int sc=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                int d=s.charAt(i) - '0';
                if (d>l){
                    sc=l;
                    l=d;
                }else if(d>sc && d<l){
                    sc=d;
                }
            }
        }
        return sc;
    }
}