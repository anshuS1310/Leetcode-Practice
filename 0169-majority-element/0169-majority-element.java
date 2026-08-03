class Solution {
    public int majorityElement(int[] nums) {
        int c=-1,c1=0;
        for(int n: nums){
            if(c1==0){
                c=n;
                c1=1;
            }else if(n==c){
                c1++;
            }else{
                c1--;
            }
        }
        c1=0;
        for(int n:nums){
            if(n==c){
                c1++;
            }
        }
        if(c1>(nums.length)/2){
            return c;
        }else{
            return -1;
        }

    }
}