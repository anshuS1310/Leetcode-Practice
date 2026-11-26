class Solution {
    public boolean canAliceWin(int n) {
        int a=10;
        Boolean ans=false;
        for(int i=0;i<=6;i++){
            if(n>=a){
                n=n-a;
                ans=!ans;
                a--;
            }else{
                break;
            }
        }
        return ans;
    }
}