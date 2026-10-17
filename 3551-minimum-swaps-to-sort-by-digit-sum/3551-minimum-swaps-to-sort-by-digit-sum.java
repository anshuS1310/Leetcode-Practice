class Solution {
    private int sum(int n){
        int res=0;
        while(n>0){
            res+=n%10;
            n/=10;
        }
        return res;
    }
    public int minSwaps(int[] nums) {
        int [][] arr=new int[nums.length][3];
        boolean [] v=new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i][0]=sum(nums[i]);
            arr[i][1]=nums[i];
            arr[i][2]=i;
        }
        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(v[i] || arr[i][2]==i){
                continue;
            }
            int j=i,cy=0;
            while(!v[j]){
                v[j]=true;
                j=arr[j][2];
                cy++;
            }
            if(cy>0){
                res+=(cy-1);
            }
        }
        return res;

    }
}