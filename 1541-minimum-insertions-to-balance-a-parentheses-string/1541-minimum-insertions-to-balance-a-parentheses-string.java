class Solution {
    public int minInsertions(String s) {
        char ch[]=s.toCharArray();
        int n=0,c=0;
        for(int i=0;i<ch.length;i++){
            if(ch[i]=='('){
                n+=2;
            }else{
                if(i+1<ch.length && ch[i+1]==')'){
                    if(n==0){
                        c++;
                    }else{
                        n-=2;
                    }
                    i++;
                }else{
                    if(n==0){
                        c+=2;
                    }else{
                        c++;
                        n-=2;
                    }
                }
            }
        }
        return n+c;
    }
}