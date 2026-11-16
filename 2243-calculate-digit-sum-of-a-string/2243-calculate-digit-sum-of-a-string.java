class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k){
            StringBuilder chk=new StringBuilder();
            int sm=0;
            for(int i=1;i<=s.length();i++){
                sm+=s.charAt(i-1)-'0';
                if(i%k==0 || i==s.length()){
                    chk.append(sm);
                    sm=0;
                }
            }
            s=chk.toString();
        }
        return s;
    }
}