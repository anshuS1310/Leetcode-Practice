
class Solution {
    public boolean isPalindrome(String s) {
       String a="";
       s=s.toLowerCase();
       for(int i=0;i<s.length();i++){
        if((s.charAt(i)>='A' && s.charAt(i)<='Z') || (s.charAt(i)>='a' && s.charAt(i)<='z') || s.charAt(i)>='0' && s.charAt(i)<='9'){
            a+=s.charAt(i);
        }
       }
       for(int i=0,j=a.length()-1;i<j;i++,j--){
        if(a.charAt(i)!=a.charAt(j)){
            return false;
        }
       }
       return true;
    }
}