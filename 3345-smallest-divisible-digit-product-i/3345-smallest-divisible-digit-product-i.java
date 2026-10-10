class Solution {
    private static int pd(int n){
        int p=1;
        while(n!=0){
            p*=n%10;
            n/=10;
        }
        return p;
    }
    public int smallestNumber(int n, int t) {
        int p=pd(n)%t;
        while(p!=0){
            n+=1;
            p=pd(n)%t;
        }
        return n;
    }
}