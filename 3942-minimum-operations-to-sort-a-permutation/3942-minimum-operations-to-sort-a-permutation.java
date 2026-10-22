class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int z=0;
        while(nums[z]!=0){
            z++;
        }
        boolean f=true,b=true;
        for(int i=0;i<n && (f||b);i++){
            int r=nums[(z+i)%n];
            f&= r==i;
            b&= r==((n-i)%n);
        }
        if(f){
            return Math.min(z,n-z+2);
        }
        if(b){
            return Math.min(z+2,n-z);
        }
        return -1;
    }
}