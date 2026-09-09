class Solution {
    public int countCommas(int n) {
        int c=0;
        for(int i=1000;i<=n;i++){
            c++;
        }
        return c;
    }
}