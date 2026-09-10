class Solution {
    public double myPow(double x, int n) {
        if (n==0 || x==1){
            return 1;
        }
        if(n<=Integer.MIN_VALUE){
            if(x<0){
                return 1;
            }
            return 0;
        }
        if(n>=Integer.MAX_VALUE){
            if(x<0){
                return -1;
            }
            return 0;
        }
        if(n<0){
            x=1/(x);
        }
        double res=x;
        for(int i=1;i<Math.abs(n);i++){
            res*=x;
        }
        return res;
        
    }
}