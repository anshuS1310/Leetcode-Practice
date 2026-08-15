class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> f=new ArrayList<>();
        f.add(1);
        ans.add(f);
        List<Integer> pr=new ArrayList<>();
        pr=f;
        for(int i=1;i<n;i++){
            List<Integer> ans1=new ArrayList<>();
            ans1.add(1);
            for(int j=1;j<i;j++){
                ans1.add((pr.get(j-1))+(pr.get(j)));
            }
            ans1.add(1);
            pr=ans1;
            ans.add(ans1);
        }
    return ans; 
    }
}