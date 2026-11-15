class Solution {
    public int numOfSubarrays(int[] arr) {
        int s=0;
        int co = 0;
        long res=0;
        for (int i = 0; i < arr.length; i++) {
            if((arr[i] & 1)==0){
                s++;
            }else{
                int p=co;
                co=s+1;
                s=p;
            }
            res+=co;
        }    
        return (int) ( res % 1000000007);
    }
}