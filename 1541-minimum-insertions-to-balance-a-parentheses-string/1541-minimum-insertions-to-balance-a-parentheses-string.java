class Solution {
    public int minInsertions(String s) {
        int a=0,n=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                n+=2;
                if(n%2!=0){
                    a++;
                    n--;
                }
            }else{
                n--;
                if(n<0){
                    a++;
                    n+=2;
                }
            }
        }
        return n+a;
    }
}