class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            String c="";
            for(int j=i;j<i+s.length();j++){
                c+=goal.charAt(j%s.length());
            }
            if(c.equals(s)){
                return true;
            }
        }
        return false;  
    }
}