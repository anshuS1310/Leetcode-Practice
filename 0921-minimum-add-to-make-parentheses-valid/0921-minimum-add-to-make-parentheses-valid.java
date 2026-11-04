class Solution {
    public int minAddToMakeValid(String s) {
        int ch=0,n=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                n++;
            }else{
                if(n>0){
                    n--;
                }else{
                    ch++;
                }
            }
        }
        return ch+n;
    }
}