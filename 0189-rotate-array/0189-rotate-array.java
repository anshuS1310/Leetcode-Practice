class Solution {
    public void rotate(int[] nums, int k) {
        int st=k%nums.length;
        int []ar=nums.clone();
        for(int i=0,j=nums.length-st;i<nums.length;i++,j++){
            nums[i]=ar[j%nums.length];
        } 
    }
}