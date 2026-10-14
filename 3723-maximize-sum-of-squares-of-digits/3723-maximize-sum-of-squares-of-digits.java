class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum>9*num){
            return "";
        }
        StringBuilder s=new StringBuilder();
        int n=sum/9;
        int r=sum%9;
        s.append("9".repeat(n));
        if(r>0){
            s.append(r);
        }
        if(num-s.length()>0){
            s.append("0".repeat(num-s.length()));
        }
        return s.toString();
    }
}