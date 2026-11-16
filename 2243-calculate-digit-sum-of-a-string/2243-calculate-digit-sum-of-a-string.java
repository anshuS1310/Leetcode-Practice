class Solution {
    public String digitSum(String s, int k) {
        if(s.length()<=k){
            return s;
        }
        StringBuilder sb=new StringBuilder();
        int ds=0;
        for(int i=0;i<s.length();i++){
            ds+=s.charAt(i)-'0';
            if((i+1)%k==0 || (i+1)==s.length()){
                sb.append(ds);
                ds=0;
            }
        }
        return digitSum(sb.toString(),k);
    }
}