class Solution {
    public List<Integer> getRow(int r) {
        List<Integer> ans=new ArrayList<>();
        if(r==0){
            ans.add(1);
            return ans;
        }
        for(int i=0;i<r;i++){
            List<Integer> pr=new ArrayList<>(ans);
            ans.clear();
            ans.add(1);
            for(int j=1;j<i+1;j++){
                ans.add((pr.get(j-1))+(pr.get(j)));
            }
            ans.add(1);
        }
    return ans; 
    }
}