class Solution {
    public int myAtoi(String s) {
        int sn=1,r=0,x=0;
        while(s.length() > x && s.charAt(x)==' '){
            x++;
        }
        if(s.length()>x && (s.charAt(x)=='-'||s.charAt(x)=='+')){
            if(s.charAt(x++)=='-'){
                sn=-1;
            }
        }
        while(s.length()>x && s.charAt(x)<='9' && s.charAt(x)>='0'){
            if(r>Integer.MAX_VALUE/10 || (r==Integer.MAX_VALUE/10 && s.charAt(x)-'0'>7)){
                return sn==1 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            r=10*r+(s.charAt(x++)-'0');
        }
        return r*sn;
    }
}