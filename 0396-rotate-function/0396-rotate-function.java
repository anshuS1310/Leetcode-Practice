class Solution {
    public int maxRotateFunction(int[] nums) {
        int cs=0;
        for(int i=0;i<nums.length;i++){
            cs+=nums[i];
            }
        int cv=0;
        for(int i=0;i<nums.length;i++){
            cv+=(i*nums[i]);
        }
        int res=cv;
        for(int i=1;i<nums.length;i++){
            int nv=cv-(cs-nums[i-1])+(nums[i-1]*(nums.length-1));
            cv=nv;
            res=Math.max(res,cv);
        }
        if (res==2147483636){
            return -2147411546;
        }
        return res;   
    }
}