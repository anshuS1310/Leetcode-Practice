class Solution {
    public int distinctEchoSubstrings(String text) {
        Set<String> h= new HashSet<>();
        for(int i=0;i<=text.length()/2;i++){
            for(int j=0,k=i,c=0;j<text.length()-i;j++,k++){
                if(text.charAt(j)==text.charAt(k)){
                    c++;
                }else{
                    c=0;
                }
                if(c==i){
                    h.add(text.substring(j-i+1,k));
                    c--;
                }
            }
        }
        return h.size();
    }
}