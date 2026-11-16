class Solution {
    public String digitSum(String s, int k) {
        String res=s;
        while(res.length()>k){
            List<String> lt=new ArrayList<>();
            String cs="";
            for(int i=0;i<res.length();i++){
                cs+=res.charAt(i);
                if(cs.length()==k){
                    lt.add(cs);
                    cs="";
                }
            }
            if(!cs.isEmpty()){
                lt.add(cs);
            }
            res=sck(lt);
        }
        return res;
    }
    private String sck(List<String> lt){
        String ans="";
        for(int i=0;i<lt.size();i++){
            String cs=lt.get(i);
            int ds=0;
            for(int j=0;j<cs.length();j++){
                ds+=cs.charAt(j)-'0';
            }
            String ss=String.valueOf(ds);
            lt.set(i,ss);
            ans+=ss;
        }    
        return ans;
    }
}