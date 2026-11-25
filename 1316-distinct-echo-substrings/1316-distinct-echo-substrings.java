class Solution {
    public int distinctEchoSubstrings(String text) {
        Set<String> h= new HashSet<>();
        for(int i=0;i<text.length()-2;i++){
            for(int j=2;i+j<=text.length();j+=2){
                int m=i+j/2;
                String s1=text.substring(i,m);
                String s2=text.substring(m,i+j);
                if(s1.equals(s2)){
                    h.add(s1);
                }
            }
        }
        return h.size();
    }
}