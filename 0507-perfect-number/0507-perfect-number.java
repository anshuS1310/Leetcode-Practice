class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum=0;
        if(num==0 || num==1){
            return false;
        }
        for(int v=(int) Math.ceil((double) num / 2);v>0;v--){
            if (num%v==0){
                sum+=v;
            }
            if(sum==num){
                    return true;
            }
            if(sum>num){
                break;
            }
        }
        return false;
    }
}