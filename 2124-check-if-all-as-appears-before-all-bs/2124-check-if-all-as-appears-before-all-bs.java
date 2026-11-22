class Solution {
    public boolean checkString(String s) {
        int c=0;
       for(int i=s.length()-1;i>=0;i--){
        if(s.charAt(i)=='a'){
            c++;
        }else if(c>0){
            return false;
        }
       }
       return true; 
    }
}