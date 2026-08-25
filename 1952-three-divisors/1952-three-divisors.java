class Solution {
    public boolean isThree(int n) {
        int a=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                a++;
            }
        }
        if(a==3){
            return true;
        }
        return false;
    }
}