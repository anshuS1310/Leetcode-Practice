class Solution {
    private static int sumof(int n){
        int s=0;
        while(n>0){
            s+=n%10;
            n/=10;
        }
        return s;
    }
    private static int prod(int n){
        int p=1;
        if(n%10==0){
            return 0;
        }
        while(n>0){
            p*=n%10;
            n/=10;
        }
        return p;
    }
    public boolean checkDivisibility(int n) {
        int ck=sumof(n)+prod(n);
        return n%ck==0;
    }
}