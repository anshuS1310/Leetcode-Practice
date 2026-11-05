class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int c=0;
        for(int i:arr1){
            int r=i+d;
            int l=i-d;
            Boolean ck=true;
            for(int j:arr2){
                if(j>=l && j<=r){
                    ck=false;
                }
            }
            if(ck){
                c++;
            }
        }
        return c;
    }
}