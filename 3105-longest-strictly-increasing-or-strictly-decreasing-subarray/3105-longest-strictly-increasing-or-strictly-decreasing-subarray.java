class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int mn=0;
        for(int i=0;i<nums.length;i++){
            List<Integer> a=new ArrayList<>();
            a.add(nums[i]);
            for(int j=i+1;j<nums.length;j++){
                if(a.get(a.size()-1)>nums[j]){
                    a.add(nums[j]);
                }else{
                    break;
                }
            }
            mn=Math.max(a.size(),mn);
        }
        for(int i=0;i<nums.length;i++){
            List<Integer> a=new ArrayList<>();
            a.add(nums[i]);
            for(int j=i+1;j<nums.length;j++){
                if(a.get(a.size()-1)<nums[j]){
                    a.add(nums[j]);
                }else{
                    break;
                }
            }
            mn=Math.max(a.size(),mn);
        }
        return mn;
    }
}