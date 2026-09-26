class Solution {
    private int myc(String s1, String s2){
        return (s2+s1).compareTo(s1+s2);
    }
    public String largestNumber(int[] nums) {
        ArrayList<String> stres=new ArrayList<>();
        for(int i:nums){
            stres.add(Integer.toString(i));
        }
        Collections.sort(stres,(a,b)->myc(a,b));
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