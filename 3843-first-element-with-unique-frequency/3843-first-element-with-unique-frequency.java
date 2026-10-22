class Solution {
    public int firstUniqueFreq(int[] nums) {
        int m=Integer.MIN_VALUE;
        for(int i:nums){
            m=Math.max(i,m);
        }
        int []f = new int[m+1];
        for(int i:nums){
            f[i]++;
        }
        int []f2=new int[nums.length+1];
        for(int i:f){
            f2[i]++;
        }
        for(int i:nums){
            if(f2[f[i]]==1){
                return i;
            }
        }
        return -1;  
    }
}