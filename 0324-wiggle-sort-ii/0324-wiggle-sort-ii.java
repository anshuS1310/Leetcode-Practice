import java.util.Arrays;
class Solution {
    public void wiggleSort(int[] nums) {
        int [] st=nums.clone();
        Arrays.sort(st);
        int s=(nums.length-1)/2,h=nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i]=st[s--];
            }else{
                nums[i]=st[h--];
            }
        }
    }
}