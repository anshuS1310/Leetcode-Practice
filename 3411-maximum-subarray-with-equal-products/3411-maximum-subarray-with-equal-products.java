class Solution {
    public int maxLength(int[] nums) {
        int n=nums.length;
        int mxl=1;
        for(int i=0;i<nums.length;i++){
            int prd=1;
            int gcd=0;
            int lcm=1;
            for(int j=i;j<nums.length;j++){
                prd*=nums[j];
                gcd=Gcd(gcd,nums[j]);
                lcm=Lcm(lcm,nums[j]);
                if(prd==gcd*lcm){
                    mxl=Math.max(mxl,j-i+1);
                }
                if(prd>25200){
                    break;
                }
            }
        }
        return mxl;  
    }
    private int Gcd(int a,int b){
        while(b!=0){
            int t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
    private int Lcm(int a,int b){
        return (a/Gcd(a,b))*b;
    }
}