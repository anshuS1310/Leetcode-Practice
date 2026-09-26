class Solution {
    private boolean myc(String s1, String s2){
        return (s1+s2).compareTo(s2+s1)>0;
    }
    public String largestNumber(int[] nums) {
        ArrayList<String> stres=new ArrayList<>();
        for(int i:nums){
            stres.add(Integer.toString(i));
        }
        Collections.sort(stres,(a,b)->myc(a,b) ? -1:1);
        if(stres.get(0).equals("0")){
            return "0";
        }
        StringBuilder res=new StringBuilder();
        for(String s: stres){
            res.append(s);
        }
        return res.toString();
    }
}