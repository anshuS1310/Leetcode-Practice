class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int n=words.length;
        List<String> ans=new ArrayList<>();
        int i=0;
        while(i<n){
            int l=words[i].length();
            int j=i+1;
            while(j<n && l+1+words[j].length()<=maxWidth){
                l=l+1+words[j].length();
                j++;
            }
            int nc=j-i;
            int tc=0;
            for(int k=i;k<j;k++){
                tc+=words[k].length();
            }
            int s=maxWidth-tc;
            StringBuilder ln=new StringBuilder();
            if(j==n||nc==1){
                for(int k=i;k<j;k++){
                    if(k>i){
                        ln.append(" ");
                    }
                    ln.append(words[k]);
                }
                while(ln.length()<maxWidth){
                    ln.append(" ");
                }
            }else{
                int sp=nc-1;
                int esp=s/sp;
                int ex=s%sp;
                for(int k=i;k<j-1;k++){
                    ln.append(words[k]);
                    int rsp=esp+(k-i<ex ? 1:0);
                    for(int l1=0;l1<rsp;l1++){
                        ln.append(" ");
                    }
                }
                ln.append(words[j-1]);
            }
            ans.add(ln.toString());
            i=j;
        }
        return ans;
    }
}