class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> res= new ArrayList<>();
        for(int i:nums){
            if(i>=10){
                String s=String.valueOf(i);
                for(char c:s.toCharArray()){
                    res.add(c-'0');
                }
            }else{
                res.add(i);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
        
    }
}